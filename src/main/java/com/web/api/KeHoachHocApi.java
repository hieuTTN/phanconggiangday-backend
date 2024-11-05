package com.web.api;

import com.web.entity.BaiViet;
import com.web.entity.KeHoachHoc;
import com.web.service.BaiVietService;
import com.web.service.KeHoachHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ke-hoach-hoc")
@CrossOrigin
public class KeHoachHocApi {

    @Autowired
    private KeHoachHocService keHoachHocService;

    @PostMapping("/admin/add")
    public ResponseEntity<?> save(@RequestBody KeHoachHoc keHoachHoc){
        KeHoachHoc result = keHoachHocService.save(keHoachHoc);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/admin/clone")
    public ResponseEntity<?> cloneKeHoachHoc(@RequestParam Long fromId, @RequestParam Long toId){
        keHoachHocService.cloneKeHoachHoc(fromId, toId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Long id){
        keHoachHocService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/public/findById")
    public ResponseEntity<?> findById(@RequestParam("id") Long id){
        KeHoachHoc result = keHoachHocService.findById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/all/findAll-page")
    public ResponseEntity<?> findAll(Pageable pageable, @RequestParam(required = false) Long khoaHocId,
                                     @RequestParam(required = false) Long nganhId ){
        Page<KeHoachHoc> result = keHoachHocService.findAll(pageable,nganhId, khoaHocId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/all/findAll-list")
    public ResponseEntity<?> findAllList(){
        List<KeHoachHoc> result = keHoachHocService.findAllList();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
