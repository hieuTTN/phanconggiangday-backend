package com.web.api;

import com.web.dto.request.KeHoachMoMonRequest;
import com.web.entity.KeHoachHoc;
import com.web.entity.KeHoachMoMon;
import com.web.service.KeHoachHocService;
import com.web.service.KeHoachMoMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) Long idKhoaHoc,
                                    @RequestParam(required = false) Long idNamHoc, @RequestParam(required = false) Long idHocKy,
                                    @RequestParam(required = false) Long idNganh){
        Page<KeHoachMoMon> result = keHoachMoMonService.findAll(pageable, idHocKy, idNamHoc, idNganh, idKhoaHoc);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/head-department/find-by-truong-bo-mon")
    public ResponseEntity<?> findByTruongBoMon(Pageable pageable, @RequestParam(required = false) Long idKhoaHoc,
                                               @RequestParam(required = false) Long idNamHoc, @RequestParam(required = false) Long idHocKy,
                                               @RequestParam(required = false) Long idNganh){
        Page<KeHoachMoMon> result = keHoachMoMonService.findByTruongBoMon(pageable, idHocKy, idNamHoc, idNganh, idKhoaHoc);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete")
    public void delete(@RequestParam Long id){
        keHoachMoMonService.delete(id);
    }
    @GetMapping("/all/find-by-id")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        KeHoachMoMon result = keHoachMoMonService.findById(id);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
}
