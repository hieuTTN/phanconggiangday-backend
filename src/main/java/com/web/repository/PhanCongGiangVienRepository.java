package com.web.repository;

import com.web.entity.KeHoachMoMon;
import com.web.entity.PhanCongGiangVien;
import com.web.enums.LoaiNhom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhanCongGiangVienRepository extends JpaRepository<PhanCongGiangVien, Long>, JpaSpecificationExecutor<PhanCongGiangVien> {

    @Query("select p from PhanCongGiangVien p where p.keHoachChiTiet.id = ?1 and p.giangVien.id = ?2")
    Optional<PhanCongGiangVien> findByGiangVienAndKeHoach(Long idKeHoach, Long idgv);

    @Query("select p from PhanCongGiangVien p where p.keHoachChiTiet.id = ?1")
    List<PhanCongGiangVien> findByKeHoachCt(Long idKeHoach);

    @Query("select p from PhanCongGiangVien p where p.giangVien.id = ?1")
    Page<PhanCongGiangVien> findByGiangVien(Long idGv, Pageable pageable);

    @Query("select p from PhanCongGiangVien p where p.giangVien.id = ?1 and p.keHoachChiTiet.namHoc.id = ?2")
    Page<PhanCongGiangVien> findByGiangVienAndNamHoc(Long idGv ,Long namHocId, Pageable pageable);

    @Query("select sum(p.soNhom) from PhanCongGiangVien p where p.giangVien.id = ?1 and p.keHoachChiTiet.namHoc.id = ?2")
    Integer soNhomDay(Long idGv, Long idNamHoc);

    @Query("select sum(p.soNhom) from PhanCongGiangVien p where p.keHoachChiTiet.id = ?2 and p.loaiNhom = ?1")
    Integer tongNhomByLoaiNhom(LoaiNhom all, Long keHoachCTId);
}
