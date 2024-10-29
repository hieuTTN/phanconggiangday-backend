package com.web.repository;

import com.web.entity.HocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {

    @Query("select h from HocPhan h where h.tenHP like ?1")
    Page<HocPhan> findByParam(String s, Pageable pageable);

    @Query("select h from HocPhan h where h.maHP = ?1")
    Optional<HocPhan> findByMaHp(String maHP);

    @Query("select h from HocPhan h where h.maHP = ?1 and h.id <> ?2")
    Optional<HocPhan> findByMaHpAndId(String maHP, Long id);
}
