package com.web.dto.response;

import com.web.entity.GiangVien;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiangVienSoTiet {

    private GiangVien giangVien;

    private Integer soTiet;

    private Integer soTietThucTe;

    public GiangVienSoTiet(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
}
