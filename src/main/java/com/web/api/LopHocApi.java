package com.web.api;

import com.web.entity.BaiViet;
import com.web.entity.LopHoc;
import com.web.service.BaiVietService;
import com.web.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lophoc")
@CrossOrigin
public class LopHocApi {

    @Autowired
    private LopHocService lopHocService;

    @PostMapping("/admin/add")
    public ResponseEntity<?> save(@RequestBody LopHoc lopHoc){
        LopHoc result = lopHocService.save(lopHoc);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        lopHocService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/public/findById")
    public ResponseEntity<?> findById(@RequestParam("id") Long id){
        LopHoc result = lopHocService.findById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/all/findAll-page")
        public ResponseEntity<?> findAll(Pageable pageable, @RequestParam(required = false) Long khoaHocId,
                                         @RequestParam(required = false) Long nganhId){
        Page<LopHoc> result = lopHocService.findAll(pageable,khoaHocId, nganhId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
