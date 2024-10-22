package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "chuyen_nganh")
@Getter
@Setter
public class ChuyenNganh {

    @Id
    @Column(name = "ma_chuyen_nganh")
    private String maChuyenNganh;

    private String tenChuyenNganh;

    @ManyToOne
    @JoinColumn(name = "ma_nganh")
    private Nganh nganh;

}
