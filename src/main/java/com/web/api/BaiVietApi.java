package com.web.api;

import com.web.entity.BaiViet;
import com.web.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bai-viet")
@CrossOrigin
public class BaiVietApi {

    @Autowired
    private BaiVietService baiVietService;

    @PostMapping("/admin/add")
    public ResponseEntity<?> save(@RequestBody BaiViet blog){
        BaiViet result = baiVietService.save(blog);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        baiVietService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/public/findById")
    public ResponseEntity<?> findById(@RequestParam("id") Long id){
        BaiViet result = baiVietService.findById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/public/findAll-page")
    public ResponseEntity<?> findAll(Pageable pageable, @RequestParam(required = false) String search){
        Page<BaiViet> result = baiVietService.findAll(pageable,search);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
