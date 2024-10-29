package com.web.api;

import com.web.entity.BoMon;
import com.web.entity.Nganh;
import com.web.service.BoMonService;
import com.web.service.NganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bomon")
@CrossOrigin
public class BoMonApi {

    @Autowired
    private BoMonService boMonService;

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(){
        List<BoMon> result = boMonService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
