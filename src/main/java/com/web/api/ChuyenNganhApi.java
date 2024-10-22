package com.web.api;

import com.web.entity.ChuyenNganh;
import com.web.entity.NamHoc;
import com.web.entity.Nganh;
import com.web.service.ChuyenNganhService;
import com.web.service.NganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chuyen-nganh")
@CrossOrigin
public class ChuyenNganhApi {


    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(){
        List<ChuyenNganh> result = chuyenNganhService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all/find-by-nganh")
    public ResponseEntity<?> findByNganh(@RequestParam String maNganh){
        List<ChuyenNganh> result = chuyenNganhService.findByMaNganh(maNganh);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add-update")
    public ResponseEntity<?> create(@RequestBody ChuyenNganh chuyenNganh) {
        ChuyenNganh result = chuyenNganhService.create(chuyenNganh);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam String maChuyenNganh){
        chuyenNganhService.delete(maChuyenNganh);
    }
}
