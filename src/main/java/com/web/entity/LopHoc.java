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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maLop ;

    private String tenLop ;

    private Integer soSinhVienHienTai;

    private Integer soSVNam ;

    private Integer soSVNu ;

    @ManyToOne
    @JoinColumn(name = "KhoaHoc")
    private KhoaHoc	khoaHoc ;

    @ManyToOne
    @JoinColumn(name = "nganh")
    private Nganh nganh;

}
