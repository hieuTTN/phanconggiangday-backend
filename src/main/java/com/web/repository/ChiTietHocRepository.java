package com.web.repository;

import com.web.entity.ChiTietHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ChiTietHocRepository extends JpaRepository<ChiTietHoc, Long> {

    @Modifying
    @Transactional
    @Query("delete from ChiTietHoc p where p.keHoachHoc.id = ?1")
    int deleteByKeHoachHoc(Long keHoachHocId);

    @Query("select c from ChiTietHoc c where c.hocPhan.id = ?1 and c.hocKy.id = ?2 and c.keHoachHoc.id = ?3")
    Optional<ChiTietHoc> findByHocPhanHocKyKhh(Long hocPhanId, Long hocKyId, Long kehoachHocId);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.id = ?1")
    Page<ChiTietHoc> findByKeHoachHoc(Long keHoachHocId, Pageable pageable);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.id = ?1 and c.hocKy.id = ?2")
    Page<ChiTietHoc> findByKeHoachHocAndHocKy(Long keHoachHocId, Long hocKyId, Pageable pageable);
}
