package com.web.api;

import com.web.entity.KeHoachChiTiet;
import com.web.service.KeHoachChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ke-hoach-chi-tiet")
@CrossOrigin
public class KeHoachChiTietApi {

    @Autowired
    private KeHoachChiTietService keHoachChiTietService;

    @GetMapping("/all/find-by-kehoach")
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) Long idNamHoc,
                                    @RequestParam(required = false) String search){
        Page<KeHoachChiTiet> result = keHoachChiTietService.findByNamHoc(search,idNamHoc,pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/head-department/find-by-namHoc")
    public ResponseEntity<?> findByTruongBoMon(Pageable pageable, @RequestParam(required = false) Long idNamHoc,
                                    @RequestParam(required = false) String search){
        Page<KeHoachChiTiet> result = keHoachChiTietService.findByNamHocAndTbm(search,idNamHoc,pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/update-soluong-sinh-vien")
    public ResponseEntity<?> updateSlSinhVienNhom(@RequestParam Long id, @RequestParam Integer soLuongSinhVienNhom){
        keHoachChiTietService.updateSlSinhVienNhom(id, soLuongSinhVienNhom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
