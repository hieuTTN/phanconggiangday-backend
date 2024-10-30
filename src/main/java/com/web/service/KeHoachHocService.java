package com.web.service;

import com.web.entity.BaiViet;
import com.web.entity.KeHoachHoc;
import com.web.exception.MessageException;
import com.web.repository.ChiTietHocRepository;
import com.web.repository.KeHoachHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class KeHoachHocService {

    @Autowired
    private KeHoachHocRepository keHoachHocRepository;

    @Autowired
    private ChiTietHocRepository chiTietHocRepository;

    public KeHoachHoc save(KeHoachHoc keHoachHoc) {
        if(keHoachHoc.getId() == null){
            Optional<KeHoachHoc> ex = keHoachHocRepository.findByKhoaHocAndNganh(keHoachHoc.getKhoaHoc().getId(), keHoachHoc.getNganh().getId());
            if(ex.isPresent()){
                throw new MessageException("Khóa học và ngành đã tồn tại");
            }
        }
        else{
            Optional<KeHoachHoc> ex = keHoachHocRepository.findByKhoaHocAndNganhAndId(keHoachHoc.getKhoaHoc().getId(), keHoachHoc.getNganh().getId(), keHoachHoc.getId());
            if(ex.isPresent()){
                throw new MessageException("Khóa học và ngành đã tồn tại");
            }
        }
        keHoachHocRepository.save(keHoachHoc);
        return keHoachHoc;
    }

    public void delete(Long id) {
        chiTietHocRepository.deleteByKeHoachHoc(id);
        keHoachHocRepository.deleteById(id);
    }


    public KeHoachHoc findById(Long id) {
        return keHoachHocRepository.findById(id).get();
    }

    public Page<KeHoachHoc> findAll(Pageable pageable, Long nganhId, Long khoaHocId) {
        Page<KeHoachHoc> page = null;
        if(nganhId == null && khoaHocId == null){
            page = keHoachHocRepository.findAll(pageable);
        }
        else if(nganhId != null && khoaHocId == null){
            page = keHoachHocRepository.findByNganh(nganhId,pageable);
        }
        else if(nganhId == null && khoaHocId != null){
            page = keHoachHocRepository.findByKhoaHoc(khoaHocId,pageable);
        }
        else if(nganhId != null && khoaHocId != null){
            page = keHoachHocRepository.findByKhoaHocAndNganh(khoaHocId,nganhId,pageable);
        }
        return page;
    }
}
