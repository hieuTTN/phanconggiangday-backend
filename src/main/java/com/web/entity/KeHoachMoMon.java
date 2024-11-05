package com.web.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ke_hoach_mo_mon")
@Getter
@Setter
public class KeHoachMoMon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime ngayTao;

    @ManyToOne
    private NamHoc namHoc;

    @ManyToOne
    private KhoaHoc khoaHoc;

    @ManyToOne
    private HocKy hocKy;

    @ManyToOne
    private Nganh nganh;

    @Transient
    private Integer tongSinhVien;
}
