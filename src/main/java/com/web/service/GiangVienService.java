package com.web.service;

import com.web.entity.GiangVien;
import com.web.entity.User;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.utils.UserUtils;
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

    @Autowired
    private UserUtils userUtils;

    public GiangVien save(GiangVien giangVien){
        Optional<GiangVien> ex = giangVienRepository.findByMaGv(giangVien.getMaCB());
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
        Optional<GiangVien> ex = giangVienRepository.findByMaGvAndId(giangVien.getMaCB(), giangVien.getId());
        if(ex.isPresent()){
            throw new MessageException("Mã giảng viên đã tồn tại");
        }
        Optional<GiangVien> exP = giangVienRepository.findByUserIdAndMaCb(giangVien.getUser().getId(), giangVien.getId());
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

    public void delete(Long id){
        try {
            giangVienRepository.deleteById(id);
        }
        catch (Exception e){
            throw new MessageException("Giảng viên đã có liên kết không thể xóa");
        }
    }

    public GiangVien findById(Long id) {
        return giangVienRepository.findById(id).get();
    }

    public List<GiangVien> findAll() {
        return giangVienRepository.findAll();
    }

    public List<GiangVien> findAllByChuyenNganh() {
        User user = userUtils.getUserWithAuthority();
        GiangVien giangVien = giangVienRepository.findByUserId(user.getId()).get();
        List<GiangVien> list = giangVienRepository.findByChuyenNganh();
        return list;
    }

    public GiangVien capNhatThongTin(GiangVien giangVien) {
        User user = userUtils.getUserWithAuthority();
        Optional<GiangVien> gv = giangVienRepository.findByUserId(user.getId());
        if(gv.isEmpty()){
            throw new MessageException("Không tìm thấy giảng viên");
        }
        giangVien.setId(gv.get().getId());
        giangVien.setMaCB(gv.get().getMaCB());
        giangVien.setUser(gv.get().getUser());
        giangVien.setDangHopDong(gv.get().getDangHopDong());
        giangVien.setBoMon(gv.get().getBoMon());
        return giangVienRepository.save(giangVien);
    }

    public GiangVien thongTinCuaToi() {
        User user = userUtils.getUserWithAuthority();
        Optional<GiangVien> gv = giangVienRepository.findByUserId(user.getId());
        if(gv.isEmpty()){
            throw new MessageException("Không tìm thấy giảng viên");
        }
        return gv.get();
    }

    public String boMonCuaToi() {
        User user = userUtils.getUserWithAuthority();
        String gv = giangVienRepository.boMonCuaToi(user.getId());
        return gv;
    }
}
