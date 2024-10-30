package com.web.api;
import com.web.entity.GiangVien;
import com.web.entity.GiangVienHocPhan;
import com.web.service.GiangVienHocPhanService;
import com.web.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/giang-vien-hoc-phan")
@CrossOrigin
public class GiangVienHocPhanApi {

    @Autowired
    private GiangVienHocPhanService giangVienHocPhanService;

    @GetMapping("/teacher/hoc-phan-cua-toi")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<GiangVienHocPhan> result = giangVienHocPhanService.findByUser(pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/teacher/add")
    public ResponseEntity<?> create(@RequestBody GiangVienHocPhan giangVienHocPhan) {
        GiangVienHocPhan result = giangVienHocPhanService.save(giangVienHocPhan);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/teacher/delete")
    public void delete(@RequestParam Long id){
        giangVienHocPhanService.delete(id);
    }
}
