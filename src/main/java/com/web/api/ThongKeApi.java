package com.web.api;

import com.web.dto.response.GiangVienCTH;
import com.web.entity.GiangVien;
import com.web.entity.KeHoachChiTiet;
import com.web.entity.Nganh;
import com.web.entity.PhanCongGiangVien;
import com.web.repository.GiangVienRepository;
import com.web.repository.KeHoachChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thong-ke")
@CrossOrigin
public class ThongKeApi {

    @Autowired
    private KeHoachChiTietRepository keHoachChiTietRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @GetMapping("/all/thong-ke-all")
    public ResponseEntity<?> getAll(@RequestParam Long idNamHoc){
        List<KeHoachChiTiet> keHoachChiTiets = keHoachChiTietRepository.findByNamHoc(idNamHoc);
        Map<String, Object> map = new HashMap<>();
        map.put("keHoachChiTiet", keHoachChiTiets);

        List<GiangVien> giangVienList = giangVienRepository.findByLoaiHopDong("Cơ hữu");
        List<GiangVienCTH> result = new ArrayList<>();
        for(GiangVien g : giangVienList){
            GiangVienCTH giangVienCTH = new GiangVienCTH();
            giangVienCTH.setGiangVien(g);
            result.add(giangVienCTH);
            for(KeHoachChiTiet k : keHoachChiTiets){
                if(k.getPhanCongGiangViens() != null && k.getPhanCongGiangViens().size() >0){
                    for(PhanCongGiangVien p : k.getPhanCongGiangViens()){
                        if(p.getGiangVien().getId() == g.getId()){
                            giangVienCTH.getPhanCongGiangViens().add(p);
                        }
                    }
                }
            }
        }
        map.put("GiangVienCTH", result);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
