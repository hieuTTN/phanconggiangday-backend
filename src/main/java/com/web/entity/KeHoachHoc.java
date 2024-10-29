package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ke_hoach_hoc")
@Getter
@Setter
public class KeHoachHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Nganh nganh;

    @ManyToOne
    private KhoaHoc khoaHoc;
}
