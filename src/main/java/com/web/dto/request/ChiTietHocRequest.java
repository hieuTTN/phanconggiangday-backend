package com.web.dto.request;

import com.web.entity.HocKy;
import com.web.entity.KeHoachHoc;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ChiTietHocRequest {

    private List<Long> listIdHocPhan = new ArrayList<>();

    private HocKy hocKy;

    private KeHoachHoc keHoachHoc;
}
