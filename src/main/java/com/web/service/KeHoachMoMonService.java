package com.web.service;

import com.web.dto.request.KeHoachMoMonRequest;
import com.web.entity.*;
import com.web.exception.MessageException;
import com.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public void save(KeHoachMoMonRequest request){
        HocKy hocKy = hocKyRepository.findById(request.getHocKyId()).get();
        NamHoc namHoc = namHocRepository.findById(request.getNamHocId()).get();
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocId()).get();

        List<Nganh> nganhs = nganhRepository.findAll();
        for(Nganh n : nganhs){
            Optional<KeHoachMoMon> ex = keHoachMoMonRepository.kiemTraTonTai(request.getKhoaHocId(), request.getHocKyId(), n.getId());
            if(ex.isPresent()){
                throw new MessageException("Đã tồn tại kế hoạch mở môn cho nghành "+n.getTenNganh());
            }
        }
        for(Nganh n : nganhs){
            Integer tongSv = lopHocRepository.totalStudent(n.getId());
            if(tongSv == null){
                tongSv = 0;
            }
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

            List<KeHoachChiTiet> list = new ArrayList<>();
            for(ChiTietHoc c : cth){
                KeHoachChiTiet keHoachChiTiet = new KeHoachChiTiet();
                keHoachChiTiet.setKeHoachMoMon(keHoachMoMon);
                keHoachChiTiet.setHocPhan(c.getHocPhan());
                keHoachChiTiet.setTongSinhVien(tongSv);
                list.add(keHoachChiTiet);
            }
            keHoachChiTietRepository.saveAll(list);
        }
    }
}
