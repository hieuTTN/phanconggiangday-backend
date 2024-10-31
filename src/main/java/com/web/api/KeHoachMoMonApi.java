package com.web.api;

import com.web.dto.request.KeHoachMoMonRequest;
import com.web.entity.KeHoachHoc;
import com.web.service.KeHoachHocService;
import com.web.service.KeHoachMoMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ke-hoach-mo-mon")
@CrossOrigin
public class KeHoachMoMonApi {

    @Autowired
    private KeHoachMoMonService keHoachMoMonService;

    @PostMapping("/admin/add")
    public ResponseEntity<?> save(@RequestBody KeHoachMoMonRequest request){
        keHoachMoMonService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
