package com.web.repository;

import com.web.entity.KeHoachChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface KeHoachChiTietRepository extends JpaRepository<KeHoachChiTiet, Long> {

    @Query("select k from KeHoachChiTiet k where k.namHoc.id = ?1 and (k.hocPhan.tenHP like ?2 or k.hocPhan.maHP like ?2)")
    Page<KeHoachChiTiet> findByNamHoc(Long idNamHoc,String search, Pageable pageable);

    @Query("select k from KeHoachChiTiet k where k.namHoc.id = ?1")
    List<KeHoachChiTiet> findByNamHoc(Long namHocId);

    @Query("select k from KeHoachChiTiet k where k.hocPhan.id = ?1 and k.namHoc.id = ?2")
    Optional<KeHoachChiTiet> findByHocPhanAndNamHoc(Long hocPhanId, Long namHocId);

    @Query("select k from KeHoachChiTiet k where k.namHoc.id = ?1 and (k.hocPhan.tenHP like ?2 or k.hocPhan.maHP like ?2 or " +
            "k.hocPhan.boMon.tenBoMon like ?2) and k.hocPhan.boMon.id = ?3")
    Page<KeHoachChiTiet> findByNamHocAndTbm(Long idNamHoc, String search, Long idBoMon, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update KeHoachChiTiet k set k.locked = true where k.namHoc.id = ?1")
    int lock(Long idNamHoc);
}
