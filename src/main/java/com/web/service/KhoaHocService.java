package com.web.service;

import com.web.entity.KhoaHoc;
import com.web.exception.MessageException;
import com.web.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KhoaHocService {

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    public KhoaHoc save(KhoaHoc khoaHoc){
        Optional<KhoaHoc> ex = khoaHocRepository.findById(khoaHoc.getMaKhoaHoc());
        if(ex.isPresent()){
            throw new MessageException("Mã khóa học đã tồn tại");
        }
        khoaHocRepository.save(khoaHoc);
        return khoaHoc;
    }

    public KhoaHoc update(KhoaHoc khoaHoc){
        Optional<KhoaHoc> ex = khoaHocRepository.findById(khoaHoc.getMaKhoaHoc());
        if(ex.isEmpty()){
            throw new MessageException("Mã khóa học không tồn tại");
        }
        khoaHocRepository.save(khoaHoc);
        return khoaHoc;
    }

    public Page<KhoaHoc> findAll(Pageable pageable){
        Page<KhoaHoc> page = khoaHocRepository.findAll(pageable);
        return page;
    }

    public void delete(String maKh){
        try {
            khoaHocRepository.deleteById(maKh);
        }
        catch (Exception e){
            throw new MessageException("Khóa học này đã được dùng không thể xóa");
        }
    }
}
