package com.web.api;

import com.web.dto.request.ChiTietHocRequest;
import com.web.entity.ChiTietHoc;
import com.web.entity.KeHoachHoc;
import com.web.service.ChiTietHocService;
import com.web.service.KeHoachHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chi-tiet-hoc")
@CrossOrigin
public class ChiTietHocApi {

    @Autowired
    private ChiTietHocService chiTietHocService;

    @PostMapping("/admin/add")
    public ResponseEntity<?> save(@RequestBody ChiTietHocRequest request){
        List<ChiTietHoc> result = chiTietHocService.saveList(request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        chiTietHocService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/public/findById")
    public ResponseEntity<?> findById(@RequestParam("id") Long id){
        ChiTietHoc result = chiTietHocService.findById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/all/findAll-page")
    public ResponseEntity<?> findAll(Pageable pageable,
                                     @RequestParam Long keHoachHocId,
                                     @RequestParam(required = false) Long hocKyId ){
        Page<ChiTietHoc> result = chiTietHocService.findByKeHoachHocAndHocKy(pageable,hocKyId, keHoachHocId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
