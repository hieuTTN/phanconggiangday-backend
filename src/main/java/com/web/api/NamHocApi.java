package com.web.api;

import com.web.entity.KhoaHoc;
import com.web.entity.NamHoc;
import com.web.service.KhoaHocService;
import com.web.service.NamHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nam-hoc")
@CrossOrigin
public class NamHocApi {


    @Autowired
    private NamHocService namHocService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<NamHoc> result = namHocService.findAll(pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add-update")
    public ResponseEntity<?> create(@RequestBody NamHoc namHoc) {
        NamHoc result = namHocService.save(namHoc);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam Long id){
        namHocService.delete(id);
    }
}
