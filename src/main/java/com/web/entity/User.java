package com.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String email;

    private String password;

    private String fullName;

    private Boolean actived;

    private String rememberKey;

    private Date createdDate;

    private String avatar;

    @ManyToOne
    @JoinColumn(name = "authority_name")
    private Authority authorities;

}

