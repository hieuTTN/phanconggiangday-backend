package com.web.repository;

import com.web.entity.KeHoachMoMon;
import com.web.entity.PhanCongGiangVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhanCongGiangVienRepository extends JpaRepository<PhanCongGiangVien, Long>, JpaSpecificationExecutor<PhanCongGiangVien> {

//    @Query("select p from PhanCongGiangVien p where p.keHoachMoMon.id = ?1 and p.giangVien.maCB = ?2")
//    Optional<PhanCongGiangVien> findByGiangVienAndKeHoach(Long idKeHoach, Long maCb);
//
//    @Query("select p from PhanCongGiangVien p where p.keHoachMoMon.id = ?1")
//    List<PhanCongGiangVien> findByKeHoachMoMon(Long idKeHoach);
//
//    @Query("select p from PhanCongGiangVien p where p.giangVien.maCB = ?1")
//    Page<PhanCongGiangVien> findByGiangVien(Long maCB, Pageable pageable);
//
//    @Query("select p from PhanCongGiangVien p where p.giangVien.maCB = ?1 and p.keHoachMoMon.namHoc.id = ?2")
//    Page<PhanCongGiangVien> findByGiangVienAndNamHoc(Long maCB,Long namHocId, Pageable pageable);
}
