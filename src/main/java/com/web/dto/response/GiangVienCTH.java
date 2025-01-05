package com.web.dto.response;

import com.web.entity.GiangVien;
import com.web.entity.KeHoachChiTiet;
import com.web.entity.PhanCongGiangVien;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GiangVienCTH {

    private GiangVien giangVien;

    private List<PhanCongGiangVien> phanCongGiangViens = new ArrayList<>();
}
