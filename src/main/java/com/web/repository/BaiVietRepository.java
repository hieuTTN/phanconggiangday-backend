package com.web.repository;

import com.web.entity.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BaiVietRepository extends JpaRepository<BaiViet, Long> {

    @Query("select v from BaiViet v where v.tieuDe like ?1")
    Page<BaiViet> findByParam(String search, Pageable pageable);
}
