package com.web.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ke_hoach_mo_mon")
@Getter
@Setter
public class KeHoachMoMon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TongSoNhom")
    private Integer tongSoNhom;

    @Column(name = "SoLuongSinhVienNhom")
    private Integer soLuongSinhVienNhom;

    private Integer tongSoSinhVien;

    @ManyToOne
    @JoinColumn(name = "KhoaHoc")
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "lopHoc")
    private LopHoc lopHoc;

    @ManyToOne
    @JoinColumn(name = "NamHoc")
    private NamHoc namHoc;

    @ManyToOne
    @JoinColumn(name = "MaHP")
    private HocPhan hocPhan;

    @OneToMany(mappedBy = "keHoachMoMon", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<KeHoachMoMonNganh> keHoachMoMonNganhs;

    @Transient
    private List<String> listMaNganh = new ArrayList<>();
}
