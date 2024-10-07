package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ke_hoach_mo_mon")
@Getter
@Setter
public class KeHoachMoMon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TongSoNhom")
    private Integer tongSoNhom;

    @Column(name = "SoLuongSinhVienNhom")
    private Integer soLuongSinhVienNhom;

    @ManyToOne
    @JoinColumn(name = "KhoaHoc")
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "NamHoc")
    private NamHoc namHoc;

    @ManyToOne
    @JoinColumn(name = "MaHP")
    private HocPhan hocPhan;
}
