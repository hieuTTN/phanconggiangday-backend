package com.web.service;

import com.web.entity.HocPhan;
import com.web.entity.KhoaHoc;
import com.web.exception.MessageException;
import com.web.repository.HocPhanRepository;
import com.web.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    public HocPhan save(HocPhan hocPhan){
        Optional<HocPhan> ex = hocPhanRepository.findById(hocPhan.getMaHP());
        if(ex.isPresent()){
            throw new MessageException("Mã học phần đã tồn tại");
        }
        hocPhanRepository.save(hocPhan);
        return hocPhan;
    }

    public HocPhan update(HocPhan hocPhan){
        Optional<HocPhan> ex = hocPhanRepository.findById(hocPhan.getMaHP());
        if(ex.isEmpty()){
            throw new MessageException("Mã học phần không tồn tại");
        }
        hocPhanRepository.save(hocPhan);
        return hocPhan;
    }

    public Page<HocPhan> findAll(Pageable pageable, String search){
        Page<HocPhan> page = null;
        if(search == null){
            page = hocPhanRepository.findAll(pageable);
        }
        else{
            page = hocPhanRepository.findByParam("%"+search+"%",pageable);
        }
        return page;
    }

    public List<HocPhan> findAll(){
        return hocPhanRepository.findAll();
    }

    public void delete(Long maHp){
        try {
            hocPhanRepository.deleteById(maHp);
        }
        catch (Exception e){
            throw new MessageException("Học phần này đã được dùng không thể xóa");
        }
    }

    public HocPhan findByMaHp(Long maHp) {
        return hocPhanRepository.findById(maHp).get();
    }
}
