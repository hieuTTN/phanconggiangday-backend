package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "giang_vien_hoc_phan")
@Getter
@Setter
public class GiangVienHocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private GiangVien giangVien;

    @ManyToOne
    private HocPhan hocPhan;
}
