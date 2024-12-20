package com.web.entity;

import com.web.enums.LoaiHocPhan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hoc_phan")
@Getter
@Setter
public class HocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maHP;

    private String tenHP;

    private Integer soTinChi;

    private Integer soTietLyThuyet;

    private Integer soTietThucHanh;

    private Integer tongSoTiet;

    private Float heSo;

    @ManyToOne
    private BoMon boMon;


}
