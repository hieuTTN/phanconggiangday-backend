package com.web.service;

import com.web.dto.response.KeHoachMoMonSpecification;
import com.web.entity.GiangVien;
import com.web.entity.KeHoachMoMon;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.KeHoachMoMonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KeHoachMoMonService {

    @Autowired
    private KeHoachMoMonRepository keHoachMoMonRepository;

    public KeHoachMoMon save(KeHoachMoMon keHoachMoMon){
        keHoachMoMonRepository.save(keHoachMoMon);
        return keHoachMoMon;
    }

    public Page<KeHoachMoMon> findAll(Pageable pageable, String maKhoaHoc, Long idNamHoc, Long maHP){
        KeHoachMoMonSpecification spec = new KeHoachMoMonSpecification(maKhoaHoc, idNamHoc, maHP);
        return keHoachMoMonRepository.findAll(spec, pageable);
    }

    public void delete(Long maCb){
        try {
            keHoachMoMonRepository.deleteById(maCb);
        }
        catch (Exception e){
            throw new MessageException("Giảng viên đã có liên kết không thể xóa");
        }
    }

    public KeHoachMoMon findById(Long id) {
        return keHoachMoMonRepository.findById(id).get();
    }
}
