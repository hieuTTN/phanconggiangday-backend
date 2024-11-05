package com.web.service;

import com.web.entity.GiangVien;
import com.web.entity.KeHoachChiTiet;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.KeHoachChiTietRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KeHoachChiTietService {

    @Autowired
    private KeHoachChiTietRepository keHoachChiTietRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private GiangVienRepository giangVienRepository;

    public Page<KeHoachChiTiet> findByNamHoc(String search,Long idNamHoc, Pageable pageable){
        if(search == null){
            search = "";
        }
        search = "%"+search+"%";
        return keHoachChiTietRepository.findByNamHoc(idNamHoc,search,pageable);
    }

    public Page<KeHoachChiTiet> findByNamHocAndTbm(String search,Long idNamHoc, Pageable pageable){
        if(search == null){
            search = "";
        }
        search = "%"+search+"%";
        GiangVien giangVien = giangVienRepository.findByUserId(userUtils.getUserWithAuthority().getId()).get();
        return keHoachChiTietRepository.findByNamHocAndTbm(idNamHoc,search,giangVien.getBoMon().getId(),pageable);
    }

    public void updateSlSinhVienNhom(Long id, Integer soLuongSinhVienNhom) {
        KeHoachChiTiet keHoachChiTiet = keHoachChiTietRepository.findById(id).get();
        if(soLuongSinhVienNhom > keHoachChiTiet.getTongSinhVien()){
            throw new MessageException("Số lượng sinh viên / nhóm không được vượt quá: "+keHoachChiTiet.getTongSinhVien());
        }
        Integer soNhom = keHoachChiTiet.getTongSinhVien() / soLuongSinhVienNhom;
        if(keHoachChiTiet.getTongSinhVien() % soLuongSinhVienNhom != 0){
            ++soNhom;
        }
        keHoachChiTiet.setSoLuongSinhVienNhom(soLuongSinhVienNhom);
        keHoachChiTiet.setTongSoNhom(soNhom);
        keHoachChiTietRepository.save(keHoachChiTiet);
    }
}
