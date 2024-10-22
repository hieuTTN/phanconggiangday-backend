package com.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ke_hoach_mo_mon_nganh")
@Getter
@Setter
public class KeHoachMoMonNganh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JsonBackReference
    private KeHoachMoMon keHoachMoMon;

    @ManyToOne
    private Nganh nganh;
}
