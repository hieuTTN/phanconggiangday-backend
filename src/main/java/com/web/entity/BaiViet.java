package com.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bai_viet")
@Getter
@Setter
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tieuDe;

    private String moTa;

    private String noiDung;

    private String anh;

    private LocalDateTime ngayTao;

    @ManyToOne
    private User user;
}
