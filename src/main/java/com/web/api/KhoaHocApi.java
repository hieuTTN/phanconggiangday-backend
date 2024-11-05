package com.web.api;

import com.web.entity.KhoaHoc;
import com.web.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khoa-hoc")
@CrossOrigin
public class KhoaHocApi {

    @Autowired
    private KhoaHocService khoaHocService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<KhoaHoc> result = khoaHocService.findAll(pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all/find-all-list")
    public ResponseEntity<?> getAllList(){
        List<KhoaHoc> result = khoaHocService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all/khoa-hoc-chua-ket-thuc")
    public ResponseEntity<?> khoaHocChuaKetThuc(){
        List<KhoaHoc> result = khoaHocService.khoaHocChuaKetThuc();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> create(@RequestBody KhoaHoc khoaHoc) {
        KhoaHoc result = khoaHocService.save(khoaHoc);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam("maKh") Long id){
        khoaHocService.delete(id);
    }
}
