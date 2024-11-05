package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "khoa_hoc_nganh_hoc")
@Getter
@Setter
public class KhoaHocNganhHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private KhoaHoc khoaHoc;

    @ManyToOne
    private Nganh nganh;
}
