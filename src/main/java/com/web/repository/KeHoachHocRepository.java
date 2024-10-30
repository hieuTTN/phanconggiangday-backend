package com.web.repository;

import com.web.entity.KeHoachHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KeHoachHocRepository extends JpaRepository<KeHoachHoc, Long> {

    @Query("select k from KeHoachHoc k where k.khoaHoc.id = ?1 and k.nganh.id = ?2")
    Optional<KeHoachHoc> findByKhoaHocAndNganh(Long khoaHocId, Long nganhId);

    @Query("select k from KeHoachHoc k where k.khoaHoc.id = ?1 and k.nganh.id = ?2 and k.id <> ?3")
    Optional<KeHoachHoc> findByKhoaHocAndNganhAndId(Long khoaHocId, Long nganhId, Long id);

    @Query("select k from KeHoachHoc k where k.nganh.id = ?1")
    Page<KeHoachHoc> findByNganh(Long nganhId, Pageable pageable);

    @Query("select k from KeHoachHoc k where k.khoaHoc.id = ?1")
    Page<KeHoachHoc> findByKhoaHoc(Long khoaHocId, Pageable pageable);

    @Query("select k from KeHoachHoc k where k.khoaHoc.id = ?1 and k.nganh.id = ?2")
    Page<KeHoachHoc> findByKhoaHocAndNganh(Long khoaHocId, Long nganhId, Pageable pageable);
}
