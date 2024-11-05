package com.web.api;

import com.web.entity.PhanCongGiangVien;
import com.web.service.PhanCongGiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phan-cong-giang-vien")
@CrossOrigin
public class PhanCongGiangVienApi {

    @Autowired
    private PhanCongGiangVienService phanCongGiangVienService;

    @GetMapping("/head-department/find-by-ke-hoach")
    public ResponseEntity<?> findByKeHoachAndTBM(@RequestParam Long keHoachId){
        List<PhanCongGiangVien> result = phanCongGiangVienService.findByKeHoach(keHoachId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/head-department/add")
    public ResponseEntity<?> createByTBM(@RequestBody PhanCongGiangVien phanCongGiangVien) {
        PhanCongGiangVien result = phanCongGiangVienService.save(phanCongGiangVien);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/head-department/delete")
    public void deleteByTbm(@RequestParam Long id){
        phanCongGiangVienService.delete(id);
    }

    @GetMapping("/teacher/phan-cong-cua-toi")
    public ResponseEntity<?> phanCongCuaToi(Pageable pageable, @RequestParam(required = false) Long idNamHoc){
        Page<PhanCongGiangVien> result = phanCongGiangVienService.phanCongCuaToi(pageable, idNamHoc);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/teacher/phan-hoi")
    public ResponseEntity<?> phanHoi(@RequestBody String phanHoi, @RequestParam Long id) {
        phanCongGiangVienService.phanHoi(phanHoi,id);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}