package com.web.repository;

import com.web.entity.KeHoachMoMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KeHoachMoMonRepository extends JpaRepository<KeHoachMoMon,Long>, JpaSpecificationExecutor<KeHoachMoMon> {

    @Query("select k from KeHoachMoMon k where k.hocPhan.maHP = ?1 and k.namHoc.id = ?2 and k.khoaHoc.maKhoaHoc = ?3")
    Optional<KeHoachMoMon> kiemTraTonTai(Long maHp, Long namHocId, String maKhoaHoc);
}
