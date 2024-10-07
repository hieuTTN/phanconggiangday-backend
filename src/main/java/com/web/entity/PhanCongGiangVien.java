package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phan_cong_giang_vien")
@Getter
@Setter
public class PhanCongGiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "soNhom")
    private Integer SoNhom;

    @ManyToOne
    @JoinColumn(name = "MaHP")
    private HocPhan hocPhan;

    @ManyToOne
    @JoinColumn(name = "MaCB")
    private GiangVien giangVien;
}
