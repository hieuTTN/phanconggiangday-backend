package com.web.repository;

import com.web.entity.GiangVienHocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GiangVienHocPhanRepository extends JpaRepository<GiangVienHocPhan, Long> {

    @Query("select g from GiangVienHocPhan g where g.hocPhan.id = ?1 and g.giangVien.id = ?2")
    Optional<GiangVienHocPhan> findByHocPhanAndGv(Long hpId, Long gvId);

    @Query("select g from GiangVienHocPhan g where g.giangVien.id = ?1")
    Page<GiangVienHocPhan> findByGiangVien(Long idgv, Pageable pageable);

    @Query("select g from GiangVienHocPhan g where g.giangVien.id = ?1")
    List<GiangVienHocPhan> findByGiangVien(Long idgv);
}
