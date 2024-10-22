package com.web.service;

import com.web.dto.response.KeHoachMoMonSpecification;
import com.web.dto.response.KeHoachMoMonTruongBmSpecification;
import com.web.entity.*;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.KeHoachMoMonNganhRepository;
import com.web.repository.KeHoachMoMonRepository;
import com.web.repository.NganhRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KeHoachMoMonService {

    @Autowired
    private KeHoachMoMonRepository keHoachMoMonRepository;

    @Autowired
    private KeHoachMoMonNganhRepository keHoachMoMonNganhRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private NganhRepository nganhRepository;

    public KeHoachMoMon save(KeHoachMoMon keHoachMoMon){
        if(keHoachMoMon.getId() != null){
            keHoachMoMonNganhRepository.deleteByKeHoachMoMon(keHoachMoMon.getId());
        }
        if(keHoachMoMon.getId() == null){
            if(keHoachMoMonRepository.kiemTraTonTai(keHoachMoMon.getHocPhan().getMaHP(), keHoachMoMon.getNamHoc().getId(), keHoachMoMon.getKhoaHoc().getMaKhoaHoc()).isPresent()){
                throw new MessageException("Môn học này đã có trong kế hoạch của học kỳ và năm học này");
            }
        }
        Integer tongSoNhom = keHoachMoMon.getTongSoSinhVien() / keHoachMoMon.getSoLuongSinhVienNhom();
        if( keHoachMoMon.getTongSoSinhVien() % keHoachMoMon.getSoLuongSinhVienNhom() != 0){
            ++tongSoNhom;
        }

        keHoachMoMon.setTongSoNhom(tongSoNhom);
        keHoachMoMonRepository.save(keHoachMoMon);
        for(String s : keHoachMoMon.getListMaNganh()){
            Nganh nganh = nganhRepository.findById(s).get();
            KeHoachMoMonNganh keHoachMoMonNganh = new KeHoachMoMonNganh();
            keHoachMoMonNganh.setKeHoachMoMon(keHoachMoMon);
            keHoachMoMonNganh.setNganh(nganh);
            keHoachMoMonNganhRepository.save(keHoachMoMonNganh);
        }
        return keHoachMoMon;
    }

    public Page<KeHoachMoMon> findAll(Pageable pageable, String maKhoaHoc, Long idNamHoc, Long maHP){
        KeHoachMoMonSpecification spec = new KeHoachMoMonSpecification(maKhoaHoc, idNamHoc, maHP);
        return keHoachMoMonRepository.findAll(spec, pageable);
    }


    public Page<KeHoachMoMon> findByTruongBoMon(Pageable pageable, String maKhoaHoc, Long idNamHoc, Long maHP){
        User user = userUtils.getUserWithAuthority();
        GiangVien giangVien = giangVienRepository.findByUserId(user.getId()).get();
        ChuyenNganh chuyenNganh = giangVien.getChuyenNganh();
        KeHoachMoMonTruongBmSpecification spec = new KeHoachMoMonTruongBmSpecification(maKhoaHoc, idNamHoc, maHP, chuyenNganh.getMaChuyenNganh());
        return keHoachMoMonRepository.findAll(spec, pageable);
    }

    public void delete(Long maCb){
        try {
            keHoachMoMonRepository.deleteById(maCb);
        }
        catch (Exception e){
            throw new MessageException("Giảng viên đã có liên kết không thể xóa");
        }
    }

    public KeHoachMoMon findById(Long id) {
        return keHoachMoMonRepository.findById(id).get();
    }
}
