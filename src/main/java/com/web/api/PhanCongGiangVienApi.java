package com.web.api;

import com.web.entity.KeHoachMoMon;
import com.web.entity.NamHoc;
import com.web.entity.PhanCongGiangVien;
import com.web.service.KeHoachMoMonService;
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

    @GetMapping("/admin/find-all")
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) String maKhoaHoc,
                                    @RequestParam(required = false) Long idNamHoc, @RequestParam(required = false) Long maHP,
                                    @RequestParam(required = false) Long maCb){
        Page<PhanCongGiangVien> result = phanCongGiangVienService.findAll(pageable, maKhoaHoc, idNamHoc, maHP, maCb);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> create(@RequestBody PhanCongGiangVien phanCongGiangVien) {
        PhanCongGiangVien result = phanCongGiangVienService.save(phanCongGiangVien);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam Long id){
        phanCongGiangVienService.delete(id);
    }

    @GetMapping("/admin/find-by-ke-hoach")
    public ResponseEntity<?> findByKeHoach(@RequestParam Long keHoachId){
        List<PhanCongGiangVien> result = phanCongGiangVienService.findByKeHoach(keHoachId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/teacher/phan-cong-cua-toi")
    public ResponseEntity<?> phanCongCuaToi(Pageable pageable,@RequestParam(required = false) Long idNamHoc){
        Page<PhanCongGiangVien> result = phanCongGiangVienService.phanCongCuaToi(pageable, idNamHoc);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
