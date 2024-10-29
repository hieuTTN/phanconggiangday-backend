package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "chi_tiet_hoc")
@Getter
@Setter
public class ChiTietHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private HocPhan hocPhan;

    @ManyToOne
    private HocKy hocKy;

    @ManyToOne
    private KeHoachHoc keHoachHoc;
}
