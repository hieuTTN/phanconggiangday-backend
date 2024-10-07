package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khoa_hoc")
@Getter
@Setter
public class KhoaHoc {

    @Id
    @Column(name = "MaKhoaHoc")
    private String maKhoaHoc;

    @Column(name = "TenKhoaHoc")
    private String tenKhoaHoc ;

}
