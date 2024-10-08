package com.web.service;

import com.web.dto.response.KeHoachMoMonSpecification;
import com.web.dto.response.PhanCongGiangVienSpecification;
import com.web.entity.GiangVien;
import com.web.entity.NamHoc;
import com.web.entity.PhanCongGiangVien;
import com.web.entity.User;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.NamHocRepository;
import com.web.repository.PhanCongGiangVienRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PhanCongGiangVienService {

    @Autowired
    private PhanCongGiangVienRepository phanCongGiangVienRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private GiangVienRepository giangVienRepository;

    public PhanCongGiangVien save(PhanCongGiangVien phanCongGiangVien){
        if(phanCongGiangVienRepository.findByGiangVienAndKeHoach(phanCongGiangVien.getKeHoachMoMon().getId(),
                phanCongGiangVien.getGiangVien().getMaCB()).isPresent()){
            throw new MessageException("Giảng viên đã được thêm, không thể thêm lại");
        }
        phanCongGiangVien.setNgayCapNhat(LocalDateTime.now());
        phanCongGiangVienRepository.save(phanCongGiangVien);
        return phanCongGiangVien;
    }

    public Page<PhanCongGiangVien> findAll(Pageable pageable, String maKhoaHoc, Long idNamHoc, Long maHP, Long maCb){
        PhanCongGiangVienSpecification spec = new PhanCongGiangVienSpecification(maKhoaHoc, idNamHoc, maHP, maCb);
        return phanCongGiangVienRepository.findAll(spec, pageable);
    }

    public void delete(Long id){
        try {
            phanCongGiangVienRepository.deleteById(id);
        }
        catch (Exception e){
            throw new MessageException("Không thể xóa do đã có liên kết");
        }
    }

    public List<PhanCongGiangVien> findByKeHoach(Long keHoachId) {
        return phanCongGiangVienRepository.findByKeHoachMoMon(keHoachId);
    }

    public Page<PhanCongGiangVien> phanCongCuaToi(Pageable pageable, Long idNamHoc) {
        Page<PhanCongGiangVien> page=  null;
        User user = userUtils.getUserWithAuthority();
        Optional<GiangVien> gv = giangVienRepository.findByUserId(user.getId());
        if(gv.isEmpty()){
            throw new MessageException("Không tìm thấy giảng viên");
        }
        if(idNamHoc == null){
            page = phanCongGiangVienRepository.findByGiangVien(gv.get().getMaCB(), pageable);
        }
        else{
            page = phanCongGiangVienRepository.findByGiangVienAndNamHoc(gv.get().getMaCB(), idNamHoc, pageable);
        }
        return page;
    }
}
