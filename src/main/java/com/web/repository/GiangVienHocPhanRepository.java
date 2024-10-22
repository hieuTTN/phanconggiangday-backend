package com.web.repository;

import com.web.entity.GiangVienHocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GiangVienHocPhanRepository extends JpaRepository<GiangVienHocPhan, Long> {

    @Query("select g from GiangVienHocPhan g where g.hocPhan.maHP = ?1 and g.giangVien.maCB = ?2")
    Optional<GiangVienHocPhan> findByHocPhanAndGv(Long maHP, Long maCB);

    @Query("select g from GiangVienHocPhan g where g.giangVien.maCB = ?1")
    Page<GiangVienHocPhan> findByGiangVien(Long maCB, Pageable pageable);
}
