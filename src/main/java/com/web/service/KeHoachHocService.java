package com.web.service;

import com.web.entity.BaiViet;
import com.web.entity.ChiTietHoc;
import com.web.entity.KeHoachHoc;
import com.web.exception.MessageException;
import com.web.repository.ChiTietHocRepository;
import com.web.repository.KeHoachHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        for(KeHoachHoc k : page.getContent()){
            Long tongChiTietHoc = chiTietHocRepository.countByKeHoachHoc(k.getId());
            Long tongHocKy = chiTietHocRepository.countKyHocByKeHoachHoc(k.getId());
            k.setSoLuongKyHoc(tongHocKy);
            k.setSoLuongChiTietHoc(tongChiTietHoc);
        }
        return page;
    }

    public void cloneKeHoachHoc(Long fromId, Long toId){
        if(fromId == toId){
            throw new MessageException("Không thể tự clone chính mình");
        }
        List<ChiTietHoc> chiTietHocs = chiTietHocRepository.findByKeHoachHoc(fromId);
        KeHoachHoc keHoachHoc = keHoachHocRepository.findById(toId).get();
        List<ChiTietHoc> result = new ArrayList<>();
        for(ChiTietHoc c : chiTietHocs){
            ChiTietHoc chiTietHoc = new ChiTietHoc();
            chiTietHoc.setHocKy(c.getHocKy());
            chiTietHoc.setHocPhan(c.getHocPhan());
            chiTietHoc.setKeHoachHoc(keHoachHoc);
            Optional<ChiTietHoc> ex = chiTietHocRepository.findByHocPhanHocKyKhh(c.getHocPhan().getId(), c.getHocKy().getId(), keHoachHoc.getId());
            if(ex.isEmpty()){
                result.add(chiTietHoc);
            }
        }
        chiTietHocRepository.saveAll(result);
    }

    public List<KeHoachHoc> findAllList() {
        return keHoachHocRepository.findAll();
    }
}
