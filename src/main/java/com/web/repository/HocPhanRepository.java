package com.web.repository;

import com.web.entity.HocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {

    @Query("select h from HocPhan h where h.tenHP like ?1")
    Page<HocPhan> findByParam(String s, Pageable pageable);
}
