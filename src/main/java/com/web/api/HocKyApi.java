package com.web.api;

import com.web.entity.BoMon;
import com.web.entity.HocKy;
import com.web.service.BoMonService;
import com.web.service.HocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hocky")
@CrossOrigin
public class HocKyApi {

    @Autowired
    private HocKyService hocKyService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(){
        List<HocKy> result = hocKyService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
