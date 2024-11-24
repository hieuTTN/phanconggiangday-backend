package com.web.dto.response;

import com.web.entity.GiangVien;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiangVienSoTiet {

    private GiangVien giangVien;

    private Double soTiet;

    private Double soTietThucTe;

    public GiangVienSoTiet(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
}
