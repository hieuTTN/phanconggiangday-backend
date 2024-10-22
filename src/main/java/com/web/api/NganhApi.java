package com.web.api;

import com.web.entity.HocPhan;
import com.web.entity.Nganh;
import com.web.service.HocPhanService;
import com.web.service.NganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nganh")
@CrossOrigin
public class NganhApi {

    @Autowired
    private NganhService nganhService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(){
        List<Nganh> result = nganhService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
