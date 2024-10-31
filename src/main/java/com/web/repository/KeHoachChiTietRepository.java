package com.web.repository;

import com.web.entity.KeHoachChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KeHoachChiTietRepository extends JpaRepository<KeHoachChiTiet, Long> {

    @Query("select k from KeHoachChiTiet k where k.hocPhan.id = ?1 and k.keHoachMoMon.khoaHoc.id = ?2 " +
            "and k.keHoachMoMon.hocKy.id = ?3 and k.keHoachMoMon.nganh.id = ?4  ")
    Optional<KeHoachChiTiet> findByHocPhan(Long hocPhanId, Long khoaHocId, Long hocKyId, Long nganhId);
}
