package com.web.service;

import com.web.entity.KhoaHoc;
import com.web.entity.NamHoc;
import com.web.exception.MessageException;
import com.web.repository.KhoaHocRepository;
import com.web.repository.NamHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NamHocService {

    @Autowired
    private NamHocRepository namHocRepository;

    public NamHoc save(NamHoc namHoc){
        namHocRepository.save(namHoc);
        return namHoc;
    }

    public Page<NamHoc> findAll(Pageable pageable){
        Page<NamHoc> page = namHocRepository.findAll(pageable);
        return page;
    }

    public void delete(Long id){
        try {
            namHocRepository.deleteById(id);
        }
        catch (Exception e){
            throw new MessageException("Năm học này đã được dùng không thể xóa");
        }
    }
}
