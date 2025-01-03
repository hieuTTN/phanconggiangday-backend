package com.web.entity;

import com.web.enums.TrangThaiKhoaHoc;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "khoa_hoc")
@Getter
@Setter
public class KhoaHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maKhoaHoc;

    private String tenKhoaHoc;

    private TrangThaiKhoaHoc trangThaiKhoaHoc;

}
