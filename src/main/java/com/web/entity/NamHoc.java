package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "nam_hoc")
@Getter
@Setter
public class NamHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TenNamHoc")
    private String tenNamHoc;

    @Column(name = "HocKy")
    private String hocKy;
}
