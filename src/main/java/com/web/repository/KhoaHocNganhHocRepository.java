package com.web.repository;

import com.web.entity.KhoaHocNganhHoc;
import com.web.entity.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhoaHocNganhHocRepository extends JpaRepository<KhoaHocNganhHoc, Long> {

    @Query("select kn.nganh from KhoaHocNganhHoc kn where kn.khoaHoc.id = ?1")
    List<Nganh> findByKhoaHoc(Long khoaHocId);

    @Query("select kn.nganh from KhoaHocNganhHoc kn where kn.khoaHoc.id = ?1 and kn.nganh.id = ?2")
    KhoaHocNganhHoc findByKhoaHocAndNganhHoc(Long khoaHocId, Long nganhId);
}
