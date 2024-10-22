package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "nganh")
@Getter
@Setter
public class Nganh {

    @Id
    @Column(name = "ma_nganh")
    private String maNganh;

    private String tenNganh;
}
