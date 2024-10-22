package com.web.service;

import com.web.entity.GiangVien;
import com.web.entity.GiangVienHocPhan;
import com.web.entity.User;
import com.web.exception.MessageException;
import com.web.repository.GiangVienHocPhanRepository;
import com.web.repository.GiangVienRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienHocPhanService {

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private GiangVienHocPhanRepository giangVienHocPhanRepository;

    public GiangVienHocPhan save(GiangVienHocPhan giangVienHocPhan){
        User user = userUtils.getUserWithAuthority();
        GiangVien giangVien = giangVienRepository.findByUserId(user.getId()).get();
        Optional<GiangVienHocPhan> ex = giangVienHocPhanRepository.findByHocPhanAndGv(giangVienHocPhan.getHocPhan().getMaHP(),giangVien.getMaCB() );
        if(ex.isPresent()){
            throw new MessageException("Đã tồn tại học phần này");
        }
        giangVienHocPhan.setGiangVien(giangVien);
        giangVienHocPhanRepository.save(giangVienHocPhan);
        return giangVienHocPhan;
    }

    public Page<GiangVienHocPhan> findByUser(Pageable pageable){
        User user = userUtils.getUserWithAuthority();
        GiangVien giangVien = giangVienRepository.findByUserId(user.getId()).get();
        Page<GiangVienHocPhan> page = giangVienHocPhanRepository.findByGiangVien(giangVien.getMaCB(),pageable);
        return page;
    }

    public void delete(Long id){
        User user = userUtils.getUserWithAuthority();
        GiangVien giangVien = giangVienRepository.findByUserId(user.getId()).get();
        GiangVienHocPhan giangVienHocPhan = giangVienHocPhanRepository.findById(id).get();
        if(giangVienHocPhan.getGiangVien().getMaCB() != giangVien.getMaCB()){
            throw new MessageException("Bạn không đủ quyền");
        }
        giangVienHocPhanRepository.deleteById(id);
    }



}
