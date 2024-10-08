package com.web.entity;

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
    @Column(name = "ID")
    private Long id;

    @Column(name = "soNhom")
    private Integer soNhom;

    private LocalDateTime ngayCapNhat;

    @ManyToOne
    @JoinColumn(name = "KeHoachMoMon")
    private KeHoachMoMon keHoachMoMon;

    @ManyToOne
    @JoinColumn(name = "MaCB")
    private GiangVien giangVien;
}
