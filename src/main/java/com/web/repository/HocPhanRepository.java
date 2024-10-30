package com.web.repository;

import com.web.entity.HocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {

    @Query("select h from HocPhan h where h.tenHP like ?1")
    Page<HocPhan> findByParam(String s, Pageable pageable);

    @Query("select h from HocPhan h where h.maHP = ?1")
    Optional<HocPhan> findByMaHp(String maHP);

    @Query("select h from HocPhan h where h.maHP = ?1 and h.id <> ?2")
    Optional<HocPhan> findByMaHpAndId(String maHP, Long id);

    @Query(value = "SELECT hp.* \n" +
            "FROM hoc_phan hp\n" +
            "LEFT JOIN chi_tiet_hoc cth ON cth.hoc_phan_id = hp.id AND cth.ke_hoach_hoc_id = ?1\n" +
            "WHERE cth.hoc_phan_id IS NULL;", nativeQuery = true)
    List<HocPhan> getAllListOutKeHoachHoc(Long keHoachHocId);

    @Query("select h from HocPhan h where h.boMon.id = ?1")
    List<HocPhan> findByBoMon(Long id);
}
