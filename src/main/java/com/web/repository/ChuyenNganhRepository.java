package com.web.repository;

import com.web.entity.ChuyenNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, String> {

    @Query("select c from ChuyenNganh c where c.nganh.maNganh = ?1")
    List<ChuyenNganh> findByNganh(String maNganh);
}
