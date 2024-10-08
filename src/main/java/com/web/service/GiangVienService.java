package com.web.service;

import com.web.entity.GiangVien;
import com.web.entity.KhoaHoc;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    public GiangVien save(GiangVien giangVien){
        Optional<GiangVien> ex = giangVienRepository.findById(giangVien.getMaCB());
        if(ex.isPresent()){
            throw new MessageException("Mã giảng viên đã tồn tại");
        }
        Optional<GiangVien> exP = giangVienRepository.findByUserId(giangVien.getUser().getId());
        if(exP.isPresent()){
            throw new MessageException("Tài khoản đã được sử dụng cho giảng viên khác");
        }
        giangVienRepository.save(giangVien);
        return giangVien;
    }

    public GiangVien update(GiangVien giangVien){
        Optional<GiangVien> ex = giangVienRepository.findById(giangVien.getMaCB());
        if(ex.isEmpty()){
            throw new MessageException("Mã giảng viên không tồn tại");
        }
        Optional<GiangVien> exP = giangVienRepository.findByUserIdAndMaCb(giangVien.getUser().getId(), giangVien.getMaCB());
        if(exP.isPresent()){
            throw new MessageException("Tài khoản đã được sử dụng cho giảng viên khác");
        }
        giangVienRepository.save(giangVien);
        return giangVien;
    }

    public Page<GiangVien> findAll(Pageable pageable, String search){
        Page<GiangVien> page = null;
        if (search == null){
            page = giangVienRepository.findAll(pageable);
        }
        else{
            page = giangVienRepository.findByParam("%"+search+"%",pageable);
        }
        return page;
    }

    public void delete(Long maCb){
        try {
            giangVienRepository.deleteById(maCb);
        }
        catch (Exception e){
            throw new MessageException("Giảng viên đã có liên kết không thể xóa");
        }
    }

    public GiangVien findByMaCb(Long maCb) {
        return giangVienRepository.findById(maCb).get();
    }

    public List<GiangVien> findAll() {
        return giangVienRepository.findAll();
    }
}
