package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lop_hoc")
@Getter
@Setter
public class LopHoc {

    @Id
    @Column(name = "MaLop")
    private String maLop ;

    @Column(name = "TenLop")
    private String tenLop ;

    @Column(name = "Khoa")
    private String khoa ;

    @Column(name = "NganhDaoTao")
    private String nganhDaoTao ;

    @Column(name = "SoSVThangTruoc")
    private Integer soSVThangTruoc ;

    @Column(name = "SoSVHienCo")
    private Integer soSVHienCo ;

    @Column(name = "SoSVNam")
    private Integer soSVNam ;

    @Column(name = "SoSVNu")
    private Integer soSVNu ;

    @ManyToOne
    @JoinColumn(name = "KhoaHoc")
    private KhoaHoc	khoaHoc ;

}
