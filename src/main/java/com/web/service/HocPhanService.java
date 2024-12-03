package com.web.service;

import com.web.entity.GiangVien;
import com.web.entity.HocPhan;
import com.web.entity.KhoaHoc;
import com.web.entity.User;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.HocPhanRepository;
import com.web.repository.KhoaHocRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private UserUtils userUtils;

    public HocPhan save(HocPhan hocPhan){
        Optional<HocPhan> ex = hocPhanRepository.findByMaHp(hocPhan.getMaHP());
        if(ex.isPresent()){
            throw new MessageException("Mã học phần đã tồn tại");
        }
        hocPhanRepository.save(hocPhan);
        return hocPhan;
    }

    public HocPhan update(HocPhan hocPhan){
        Optional<HocPhan> ex = hocPhanRepository.findByMaHpAndId(hocPhan.getMaHP(), hocPhan.getId());
        if(ex.isPresent()){
            throw new MessageException("Mã học phần đã tồn tại");
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

    public void delete(Long id){
        try {
            hocPhanRepository.deleteById(id);
        }
        catch (Exception e){
            throw new MessageException("Học phần này đã được dùng không thể xóa");
        }
    }

    public HocPhan findByMaHp(Long id) {
        return hocPhanRepository.findById(id).get();
    }

    public List<HocPhan> getAllListOutKeHoachHoc(Long keHoachHocId) {
        return hocPhanRepository.getAllListOutKeHoachHoc(keHoachHocId);
    }

    public List<HocPhan> findByGiangVien() {
        User user = userUtils.getUserWithAuthority();
        Optional<GiangVien> gv = giangVienRepository.findByUserId(user.getId());
        if(gv.isEmpty()){
            return new ArrayList<HocPhan>();
        }
        return hocPhanRepository.findByBoMon(gv.get().getBoMon().getId());
    }

    public List<HocPhan> findByNamHoc(Long idNamHoc) {
        List<HocPhan> list = hocPhanRepository.findByNamHoc(idNamHoc);
        return list;
    }
}
