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
    @JoinColumn(name = "ma_cb")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "ma_hp")
    private HocPhan hocPhan;
}
