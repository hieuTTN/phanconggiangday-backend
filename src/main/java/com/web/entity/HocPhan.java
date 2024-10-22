package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hoc_phan")
@Getter
@Setter
public class HocPhan {

    @Id
    @Column(name = "MaHP")
    private Long maHP;

    @Column(name = "TenHP")
    private String tenHP;

    @Column(name = "SoTinChi")
    private Integer soTinChi;

    @Column(name = "SoTietLyThuyet")
    private Integer soTietLyThuyet;

    @Column(name = "SoTietThucHanh")
    private Integer soTietThucHanh;

    @Column(name = "TongSoTiet")
    private Integer tongSoTiet;

    @Column(name = "HeSo")
    private Float heSo;

    @ManyToOne
    private ChuyenNganh chuyenNganh;


}
