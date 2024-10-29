package com.web.api;

import com.web.entity.HocPhan;
import com.web.entity.KhoaHoc;
import com.web.service.HocPhanService;
import com.web.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoc-phan")
@CrossOrigin
public class HocPhanApi {

    @Autowired
    private HocPhanService hocPhanService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) String search){
        Page<HocPhan> result = hocPhanService.findAll(pageable, search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all/find-all-list")
    public ResponseEntity<?> getAllList(){
        List<HocPhan> result = hocPhanService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> create(@RequestBody HocPhan hocPhan) {
        HocPhan result = hocPhanService.save(hocPhan);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PostMapping("/admin/update")
    public ResponseEntity<?> update(@RequestBody HocPhan hocPhan) {
        HocPhan result = hocPhanService.update(hocPhan);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam Long id){
        hocPhanService.delete(id);
    }

    @GetMapping("/all/find-by-id")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        HocPhan result = hocPhanService.findByMaHp(id);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

}
