package com.web.repository;

import com.web.entity.KeHoachMoMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KeHoachMoMonRepository extends JpaRepository<KeHoachMoMon,Long>, JpaSpecificationExecutor<KeHoachMoMon> {

    @Query("select k from KeHoachMoMon k where k.khoaHoc.id = ?1 and k.hocKy.id = ?2 and k.nganh.id = ?3")
    Optional<KeHoachMoMon> kiemTraTonTai(Long khoaHocId, Long hocKyId, Long nganhId);

    @Query("select k from KeHoachMoMon k where k.namHoc.id = ?1 and k.khoaHoc.id = ?2")
    List<KeHoachMoMon> findByNamHocAndKhoaHoc(Long idNamHoc, Long KhoaHocId);

    @Query("select k from KeHoachMoMon k where k.namHoc.id = ?1")
    List<KeHoachMoMon> findByNamHoc(Long idNamHoc);
}
