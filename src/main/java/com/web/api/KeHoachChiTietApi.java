package com.web.api;

import com.web.dto.request.KeHoachMoMonRequest;
import com.web.entity.KeHoachChiTiet;
import com.web.entity.KeHoachMoMon;
import com.web.service.KeHoachChiTietService;
import com.web.service.KeHoachMoMonService;
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
    public ResponseEntity<?> getAll(Pageable pageable, @RequestParam(required = false) Long idKeHoach){
        Page<KeHoachChiTiet> result = keHoachChiTietService.findByKeHoach(idKeHoach,pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/update-soluong-sinh-vien")
    public ResponseEntity<?> updateSlSinhVienNhom(@RequestParam Long id, @RequestParam Integer soLuongSinhVienNhom){
        keHoachChiTietService.updateSlSinhVienNhom(id, soLuongSinhVienNhom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
