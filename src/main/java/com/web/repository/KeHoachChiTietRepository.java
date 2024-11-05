package com.web.repository;

import com.web.entity.KeHoachChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KeHoachChiTietRepository extends JpaRepository<KeHoachChiTiet, Long> {

    @Query("select k from KeHoachChiTiet k where k.namHoc.id = ?1")
    Page<KeHoachChiTiet> findByKeHoach(Long keHoachId, Pageable pageable);

    @Query("select k from KeHoachChiTiet k where k.namHoc.id = ?1")
    List<KeHoachChiTiet> findByNamHoc(Long namHocId);

    @Query("select k from KeHoachChiTiet k where k.hocPhan.id = ?1 and k.namHoc.id = ?2")
    Optional<KeHoachChiTiet> findByHocPhanAndNamHoc(Long hocPhanId, Long namHocId);
}
