package com.web.api;

import com.web.entity.GiangVien;
import com.web.service.GiangVienService;
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

    @GetMapping("/head-department/find-all-by-chuyen-nganh")
    public ResponseEntity<?> getAllByChuyenNganh(){
        List<GiangVien> result = giangVienService.findAllByChuyenNganh();
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
    public void delete(@RequestParam Long id){
        giangVienService.delete(id);
    }


    @GetMapping("/all/find-by-id")
    public ResponseEntity<?> findByMaHp(@RequestParam Long id) {
        GiangVien result = giangVienService.findById(id);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/head-department/thong-tin-cua-toi")
    public ResponseEntity<?> thongTinCuaToiByTBM() {
        GiangVien result = giangVienService.thongTinCuaToi();
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

    @PostMapping("/head-department/cap-nhat-thong-tin")
    public ResponseEntity<?> capNhatThongTinByTBM(@RequestBody GiangVien giangVien) {
        GiangVien result = giangVienService.capNhatThongTin(giangVien);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }



}
