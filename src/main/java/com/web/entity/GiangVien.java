package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "giang_vien")
@Getter
@Setter
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maCB;

    private String tenGV;

    private Date ngaySinh;

    private String hocVi;

    private String chucDanh;

    private String donViCongTac;

    private String dienThoai;

    private String dangHopDong;

    @ManyToOne
    private User user;

    @ManyToOne
    private BoMon boMon;
}
