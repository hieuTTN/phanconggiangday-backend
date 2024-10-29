package com.web.repository;

import com.web.entity.GiangVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {

    @Query("select g from GiangVien g where g.user.id = ?1")
    Optional<GiangVien> findByUserId(Long userId);

    @Query("select g from GiangVien g where g.user.id = ?1 and g.id <> ?2")
    Optional<GiangVien> findByUserIdAndMaCb(Long userId, Long macb);

    @Query("select g from GiangVien g where g.tenGV like ?1 or g.dienThoai like ?1 or g.chucDanh like ?1")
    Page<GiangVien> findByParam(String s, Pageable pageable);

    @Query("select g from GiangVien g ")
    List<GiangVien> findByChuyenNganh();

    @Query("select g from GiangVien g where g.maCB = ?1")
    Optional<GiangVien> findByMaGv(String maCB);

    @Query("select g from GiangVien g where g.maCB = ?1 and g.id <> ?2")
    Optional<GiangVien> findByMaGvAndId(String maCB, Long id);
}
