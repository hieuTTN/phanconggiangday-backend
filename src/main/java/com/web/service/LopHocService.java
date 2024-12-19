package com.web.service;

import com.web.entity.BaiViet;
import com.web.entity.LopHoc;
import com.web.repository.BaiVietRepository;
import com.web.repository.LopHocRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LopHocService {

    @Autowired
    private LopHocRepository lopHocRepository;


    public LopHoc save(LopHoc lopHoc) {
        LopHoc result = lopHocRepository.save(lopHoc);
        return result;
    }

    public void delete(Long id) {
        lopHocRepository.deleteById(id);
    }

    public LopHoc findById(Long id) {
        return lopHocRepository.findById(id).get();
    }

    public Page<LopHoc> findAll(Pageable pageable, Long khoaHocId, Long nganhId,String search) {
        Page<LopHoc> page = null;
        if(search != null){
            search = "%"+search+"%";
            page = lopHocRepository.findByParam(search, pageable);
        }
        else if(khoaHocId == null && nganhId == null){
            page = lopHocRepository.findAll(pageable);
        }
        else if (khoaHocId != null && nganhId == null) {
            page = lopHocRepository.findByKhoaHoc(khoaHocId,pageable);
        }
        else if (khoaHocId == null && nganhId != null) {
            page = lopHocRepository.findByNganh(nganhId,pageable);
        }
        else if (khoaHocId != null && nganhId != null) {
            page = lopHocRepository.findByNganhAndKhoaHoc(nganhId, khoaHocId,pageable);
        }
        return page;
    }

}
