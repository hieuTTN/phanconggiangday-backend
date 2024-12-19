package com.web.repository;

import com.web.entity.HocKy;
import com.web.entity.NamHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NamHocRepository extends JpaRepository<NamHoc, Long> {

    @Query(value = "select * from nam_hoc order by id desc limit 6", nativeQuery = true)
    List<NamHoc> findAll();

    @Query(value = "select * from nam_hoc order by id desc limit 1", nativeQuery = true)
    NamHoc top1();
}
