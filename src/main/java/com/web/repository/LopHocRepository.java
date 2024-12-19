package com.web.repository;

import com.web.entity.LopHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LopHocRepository extends JpaRepository<LopHoc, Long> {

    @Query("select l from LopHoc l where l.khoaHoc.id = ?1")
    Page<LopHoc> findByKhoaHoc(Long khoaHocId, Pageable pageable);

    @Query("select l from LopHoc l where l.nganh.id = ?1")
    Page<LopHoc> findByNganh(Long nganhId, Pageable pageable);

    @Query("select l from LopHoc l where l.nganh.id = ?1 and l.khoaHoc.id = ?2")
    Page<LopHoc> findByNganhAndKhoaHoc(Long nganhId,Long khoaHocId, Pageable pageable);

    @Query("select sum(l.soSinhVienHienTai) from LopHoc l where l.nganh.id = ?1")
    Integer totalStudent(Long nganhId);

    @Query("select sum(l.soSinhVienHienTai) from LopHoc l where l.khoaHoc.id = ?1 and l.nganh.id = ?2")
    Integer tongSinhVien(Long khoaHocId, Long nganhId);

    @Query("select l from LopHoc l where l.maLop like ?1")
    Page<LopHoc> findByParam(String search, Pageable pageable);
}
