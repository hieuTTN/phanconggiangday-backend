package com.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ke_hoach_chi_tiet")
@Getter
@Setter
public class KeHoachChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer soLuongSinhVienNhom;

    private Integer tongSoNhom;

    private Integer tongSinhVien;

    private Integer tongSinhVienThamKhao;

    private Boolean locked;

    @ManyToOne
    private HocPhan hocPhan;

    @ManyToOne
    private NamHoc namHoc;

    @OneToMany(mappedBy = "keHoachChiTiet", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"keHoachChiTiet"})
    private List<PhanCongGiangVien> phanCongGiangViens;
}
