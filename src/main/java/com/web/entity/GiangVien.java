package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "giang_vien")
@Getter
@Setter
public class GiangVien {

    @Id
    @Column(name = "MaCB")
    private Long maCB;

    @Column(name = "TenGV")
    private String tenGV;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @ManyToOne
    private ChuyenNganh chuyenNganh;

    @Column(name = "HocVi")
    private String hocVi;

    @Column(name = "ChucDanh")
    private String chucDanh;

    @Column(name = "DonViCongTac")
    private String donViCongTac;

    @Column(name = "DienThoai")
    private String dienThoai;

    @Column(name = "DangHopDong")
    private String dangHopDong;

    @ManyToOne
    private User user;

}
