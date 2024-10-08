package com.web.service;

import com.web.dto.response.KeHoachMoMonSpecification;
import com.web.dto.response.PhanCongGiangVienSpecification;
import com.web.entity.NamHoc;
import com.web.entity.PhanCongGiangVien;
import com.web.exception.MessageException;
import com.web.repository.NamHocRepository;
import com.web.repository.PhanCongGiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PhanCongGiangVienService {

    @Autowired
    private PhanCongGiangVienRepository phanCongGiangVienRepository;

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
}
