package com.web.dto.response;

import com.web.entity.GiangVienHocPhan;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GiangVienHocPhanDto {

    private List<GiangVienHocPhan> giangVienHocPhans;

    private Integer soNhomDay;
}
