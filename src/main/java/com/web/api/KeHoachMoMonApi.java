package com.web.api;

import com.web.entity.HocPhan;
import com.web.entity.KeHoachMoMon;
import com.web.entity.KhoaHoc;
import com.web.service.KeHoachMoMonService;
import com.web.service.KhoaHocService;
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

    @GetMapping("/all/find-all")
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) String maKhoaHoc,
                                    @RequestParam(required = false) Long idNamHoc, @RequestParam(required = false) Long maHP){
        Page<KeHoachMoMon> result = keHoachMoMonService.findAll(pageable, maKhoaHoc, idNamHoc, maHP);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/head-department/find-by-truong-bo-mon")
    public ResponseEntity<?> findByTruongBoMon(Pageable pageable, @RequestParam(required = false) String maKhoaHoc,
                                    @RequestParam(required = false) Long idNamHoc, @RequestParam(required = false) Long maHP){
        Page<KeHoachMoMon> result = keHoachMoMonService.findByTruongBoMon(pageable, maKhoaHoc, idNamHoc, maHP);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> create(@RequestBody KeHoachMoMon keHoachMoMon) {
        KeHoachMoMon result = keHoachMoMonService.save(keHoachMoMon);
        return new ResponseEntity(result, HttpStatus.CREATED);
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
