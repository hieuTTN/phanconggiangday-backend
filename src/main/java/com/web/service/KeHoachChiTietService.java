package com.web.service;

import com.web.entity.GiangVien;
import com.web.entity.HocPhan;
import com.web.entity.KeHoachChiTiet;
import com.web.entity.NamHoc;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.HocPhanRepository;
import com.web.repository.KeHoachChiTietRepository;
import com.web.repository.NamHocRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KeHoachChiTietService {

    @Autowired
    private KeHoachChiTietRepository keHoachChiTietRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private NamHocRepository namHocRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    public Page<KeHoachChiTiet> findByNamHoc(String search,Long idNamHoc,Long idBoMon, Pageable pageable){
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

    public void updateTongSinhVien(Long id, Integer soLuong) {
        KeHoachChiTiet keHoachChiTiet = keHoachChiTietRepository.findById(id).get();
        if(keHoachChiTiet.getLocked() != null && keHoachChiTiet.getLocked() == true){
            throw new MessageException("Kế hoạch này đã khóa, không thể cập nhật");
        }
        if(keHoachChiTiet.getSoLuongSinhVienNhom() != null){
            System.out.println("so luong sv nhom: "+keHoachChiTiet.getSoLuongSinhVienNhom());
            Integer soNhom = soLuong / keHoachChiTiet.getSoLuongSinhVienNhom();
            if(soLuong % keHoachChiTiet.getSoLuongSinhVienNhom() != 0){
                ++soNhom;
            }
            keHoachChiTiet.setTongSoNhom(soNhom);
            System.out.println("tong nhom: "+soNhom);
        }
        keHoachChiTiet.setTongSinhVien(soLuong);
        System.out.println("soluong tong: "+soLuong);
        System.out.println("soluong tong: "+keHoachChiTiet.getTongSinhVien());
        keHoachChiTietRepository.save(keHoachChiTiet);
    }

    public void lock(Long idNamHoc) {
        keHoachChiTietRepository.lock(idNamHoc);
    }

    public void lockSingle(Long id) {
        KeHoachChiTiet keHoachChiTiet = keHoachChiTietRepository.findById(id).get();
        if(keHoachChiTiet.getLocked() == null){
            keHoachChiTiet.setLocked(true);
        }
        else{
            if(keHoachChiTiet.getLocked() == false){
                keHoachChiTiet.setLocked(true);
            }
            else{
                keHoachChiTiet.setLocked(false);
            }
        }
        keHoachChiTietRepository.save(keHoachChiTiet);
    }

    public void create(Long idMonHoc, Long idNamHoc, Integer tongSv, Integer soLuongSvNhom) {
        Optional<KeHoachChiTiet> keHoachChiTiet = keHoachChiTietRepository.findByHocPhanAndNamHoc(idMonHoc, idNamHoc);
        if(keHoachChiTiet.isPresent()){
            throw new MessageException("Học phần này đã được mở cho học kỳ và năm học này");
        }
        NamHoc namHoc = namHocRepository.findById(idNamHoc).get();
        HocPhan hocPhan = hocPhanRepository.findById(idMonHoc).get();
        KeHoachChiTiet k = new KeHoachChiTiet();
        k.setNamHoc(namHoc);
        k.setLocked(false);
        k.setHocPhan(hocPhan);
        k.setTongSinhVien(tongSv);
        k.setSoLuongSinhVienNhom(soLuongSvNhom);
        if(tongSv != null && soLuongSvNhom != null){
            Integer soNhom = tongSv / soLuongSvNhom;
            if(tongSv % soLuongSvNhom != 0){
                ++soNhom;
            }
            k.setTongSoNhom(soNhom);
        }
        keHoachChiTietRepository.save(k);
    }

    public void delete(Long id) {
        keHoachChiTietRepository.deleteById(id);
    }
}
