package com.web.api;

import com.web.entity.GiangVien;
import com.web.entity.HocPhan;
import com.web.service.GiangVienService;
import com.web.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giang-vien")
@CrossOrigin
public class GiangVienApi {

    @Autowired
    private GiangVienService giangVienService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) String search){
        Page<GiangVien> result = giangVienService.findAll(pageable, search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all/find-all-list")
    public ResponseEntity<?> getAllList(){
        List<GiangVien> result = giangVienService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> create(@RequestBody GiangVien giangVien) {
        GiangVien result = giangVienService.save(giangVien);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PostMapping("/admin/update")
    public ResponseEntity<?> update(@RequestBody GiangVien giangVien) {
        GiangVien result = giangVienService.update(giangVien);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam("maCb") Long maCb){
        giangVienService.delete(maCb);
    }

    @GetMapping("/all/find-by-macb")
    public ResponseEntity<?> findByMaHp(@RequestParam("maCb") Long maCb) {
        GiangVien result = giangVienService.findByMaCb(maCb);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/teacher/thong-tin-cua-toi")
    public ResponseEntity<?> thongTinCuaToi() {
        GiangVien result = giangVienService.thongTinCuaToi();
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PostMapping("/teacher/cap-nhat-thong-tin")
    public ResponseEntity<?> capNhatThongTin(@RequestBody GiangVien giangVien) {
        GiangVien result = giangVienService.capNhatThongTin(giangVien);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }



}
