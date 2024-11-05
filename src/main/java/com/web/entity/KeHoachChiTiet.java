package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ke_hoach_chi_tiet")
@Getter
@Setter
public class KeHoachChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer soLuongSinhVienNhom;

    private Integer tongSoNhom;

    private Integer tongSinhVien;

    @ManyToOne
    private HocPhan hocPhan;

    @ManyToOne
    private NamHoc namHoc;

}
