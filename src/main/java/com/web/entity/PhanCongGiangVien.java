package com.web.entity;

import com.web.enums.LoaiNhom;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phan_cong_giang_vien")
@Getter
@Setter
public class PhanCongGiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer soNhom;

    @Enumerated(EnumType.STRING)
    private LoaiNhom loaiNhom;

    private LocalDateTime ngayCapNhat;

    @ManyToOne
    private KeHoachChiTiet keHoachChiTiet;

    @ManyToOne
    private GiangVien giangVien;
}
