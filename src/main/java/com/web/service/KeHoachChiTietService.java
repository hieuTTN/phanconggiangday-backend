package com.web.service;

import com.web.entity.KeHoachChiTiet;
import com.web.exception.MessageException;
import com.web.repository.KeHoachChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeHoachChiTietService {

    @Autowired
    private KeHoachChiTietRepository keHoachChiTietRepository;

    public Page<KeHoachChiTiet> findByKeHoach(Long idKeHoach, Pageable pageable){
        return keHoachChiTietRepository.findByKeHoach(idKeHoach,pageable);
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
