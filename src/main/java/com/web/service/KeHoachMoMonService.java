package com.web.service;

import com.web.dto.request.KeHoachMoMonRequest;
import com.web.dto.response.KeHoachMoMonSpecification;
import com.web.dto.response.KeHoachMoMonTruongBmSpecification;
import com.web.entity.*;
import com.web.exception.MessageException;
import com.web.repository.*;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KeHoachMoMonService {

    @Autowired
    private KeHoachMoMonRepository keHoachMoMonRepository;

    @Autowired
    private KeHoachChiTietRepository keHoachChiTietRepository;

    @Autowired
    private NganhRepository nganhRepository;

    @Autowired
    private ChiTietHocRepository chiTietHocRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private HocKyRepository hocKyRepository;

    @Autowired
    private NamHocRepository namHocRepository;

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private KeHoachHocRepository keHoachHocRepository;

    @Autowired
    private KhoaHocNganhHocRepository khoaHocNganhHocRepository;

    public void save(KeHoachMoMonRequest request){
        HocKy hocKy = hocKyRepository.findById(request.getHocKyId()).get();
        NamHoc namHoc = namHocRepository.findById(request.getNamHocId()).get();
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocId()).get();
        List<Nganh> nganhs = khoaHocNganhHocRepository.findByKhoaHoc(request.getKhoaHocId());
        for(Nganh n : nganhs){
            Optional<KeHoachMoMon> ex = keHoachMoMonRepository.kiemTraTonTai(request.getKhoaHocId(), request.getHocKyId(), n.getId());
            if(ex.isPresent()){
                throw new MessageException("Đã tồn tại kế hoạch mở môn cho nghành "+n.getTenNganh());
            }
        }
        for(Nganh n : nganhs){
            List<ChiTietHoc> cth = chiTietHocRepository.findByNganhAndHocKy(n.getId(), request.getHocKyId());
            if(cth.size() == 0){
                continue;
            }
            KeHoachMoMon keHoachMoMon = new KeHoachMoMon();
            keHoachMoMon.setNgayTao(LocalDateTime.now());
            keHoachMoMon.setNganh(n);
            keHoachMoMon.setHocKy(hocKy);
            keHoachMoMon.setNamHoc(namHoc);
            keHoachMoMon.setKhoaHoc(khoaHoc);
            keHoachMoMonRepository.save(keHoachMoMon);
        }
        updateSoLuongTong(request.getNamHocId());
    }

    public void updateSoLuongTong(Long idNamHoc){
        NamHoc namHoc = namHocRepository.findById(idNamHoc).get();
        List<KeHoachMoMon> keHoachMoMons = keHoachMoMonRepository.findByNamHoc(idNamHoc);

        List<ChiTietHoc> allChiTietHoc = new ArrayList<>();
        for(KeHoachMoMon k : keHoachMoMons){
            // lấy danh sách chi tiết học, chủ yếu là lấy học phần học
            List<ChiTietHoc> chiTietHocs = chiTietHocRepository.findByNganhAndHocKy(k.getNganh().getId(), k.getHocKy().getId(), k.getKhoaHoc().getId());
            for(ChiTietHoc c : chiTietHocs){
                Optional<KeHoachChiTiet> ex = keHoachChiTietRepository.findByHocPhanAndNamHoc(c.getHocPhan().getId(), idNamHoc);
                if(ex.isEmpty()){
                    KeHoachChiTiet keHoachChiTiet = new KeHoachChiTiet();
                    keHoachChiTiet.setHocPhan(c.getHocPhan());
                    keHoachChiTiet.setNamHoc(namHoc);
                    keHoachChiTietRepository.save(keHoachChiTiet);
                }
            }
            allChiTietHoc.addAll(chiTietHocs);
        }

        System.out.println("size chi tiet hoc: "+allChiTietHoc.size());
        // lấy danh sách kế hoạch chi tiết theo năm học, chủ yếu là các học phần để tính toán tổng sinh viên
        List<KeHoachChiTiet> keHoachChiTiets = keHoachChiTietRepository.findByNamHoc(idNamHoc);
        for(KeHoachChiTiet k : keHoachChiTiets){
            Integer tongSv = 0;
            for(ChiTietHoc c : allChiTietHoc){
                if(c.getHocPhan().getId() == k.getHocPhan().getId()){
                    Integer totalSv = lopHocRepository.tongSinhVien(c.getKeHoachHoc().getKhoaHoc().getId(), c.getKeHoachHoc().getNganh().getId());
                    if(totalSv == null){
                        totalSv = 0;
                    }
                    tongSv += totalSv;
                }
            }
            System.out.println("tong sv: "+tongSv);
            k.setTongSinhVien(tongSv);
            keHoachChiTietRepository.save(k);
        }

    }

    public Page<KeHoachMoMon> findAll(Pageable pageable, Long hocKyId, Long idNamHoc, Long nganhId, Long khoaHocId){
        KeHoachMoMonSpecification spec = new KeHoachMoMonSpecification(hocKyId, idNamHoc, nganhId, khoaHocId);
        return keHoachMoMonRepository.findAll(spec, pageable);
    }

    public Page<KeHoachMoMon> findByTruongBoMon(Pageable pageable, Long hocKyId, Long idNamHoc, Long nganhId, Long khoaHocId){
        User user = userUtils.getUserWithAuthority();
        GiangVien giangVien = giangVienRepository.findByUserId(user.getId()).get();
        KeHoachMoMonTruongBmSpecification spec = new KeHoachMoMonTruongBmSpecification(hocKyId, idNamHoc, nganhId, khoaHocId, giangVien.getBoMon().getId());
        return keHoachMoMonRepository.findAll(spec, pageable);
    }

    public void delete(Long id){
        try {
            KeHoachMoMon keHoachMoMon = keHoachMoMonRepository.findById(id).get();
            keHoachMoMonRepository.deleteById(id);
            updateSoLuongTong(keHoachMoMon.getNamHoc().getId());
        }
        catch (Exception e){
            throw new MessageException("Đã có liên kết không thể xóa");
        }
    }

    public KeHoachMoMon findById(Long id) {
        return keHoachMoMonRepository.findById(id).get();
    }
}
