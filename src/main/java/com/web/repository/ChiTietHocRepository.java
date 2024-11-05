package com.web.repository;

import com.web.entity.ChiTietHoc;
import com.web.entity.Nganh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ChiTietHocRepository extends JpaRepository<ChiTietHoc, Long> {

    @Modifying
    @Transactional
    @Query("delete from ChiTietHoc p where p.keHoachHoc.id = ?1")
    int deleteByKeHoachHoc(Long keHoachHocId);

    @Query("select c from ChiTietHoc c where c.hocPhan.id = ?1 and c.hocKy.id = ?2 and c.keHoachHoc.id = ?3")
    Optional<ChiTietHoc> findByHocPhanHocKyKhh(Long hocPhanId, Long hocKyId, Long kehoachHocId);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.id = ?1")
    Page<ChiTietHoc> findByKeHoachHoc(Long keHoachHocId, Pageable pageable);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.id = ?1")
    List<ChiTietHoc> findByKeHoachHoc(Long keHoachHocId);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.id = ?1 and c.hocKy.id = ?2")
    Page<ChiTietHoc> findByKeHoachHocAndHocKy(Long keHoachHocId, Long hocKyId, Pageable pageable);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.nganh.id = ?1 and c.hocKy.id = ?2")
    List<ChiTietHoc> findByNganhAndHocKy(Long id, Long hocKyId);

    @Query("select c from ChiTietHoc c where c.keHoachHoc.nganh.id = ?1 and c.hocKy.id = ?2 and c.keHoachHoc.khoaHoc.id = ?3")
    List<ChiTietHoc> findByNganhAndHocKy(Long nganhId, Long hocKyId, Long khoaHocId);

    @Query("select count(c.id) from ChiTietHoc c where c.keHoachHoc.id = ?1")
    Long countByKeHoachHoc(Long id);

    @Query(value = "SELECT COUNT(DISTINCT c.hoc_ky_id) AS hoc_ky_count\n" +
            "FROM chi_tiet_hoc c\n" +
            "WHERE c.ke_hoach_hoc_id = ?1", nativeQuery = true)
    Long countKyHocByKeHoachHoc(Long id);
}
