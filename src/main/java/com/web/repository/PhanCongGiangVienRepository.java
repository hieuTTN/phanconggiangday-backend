package com.web.repository;

import com.web.entity.KeHoachMoMon;
import com.web.entity.PhanCongGiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhanCongGiangVienRepository extends JpaRepository<PhanCongGiangVien, Long>, JpaSpecificationExecutor<PhanCongGiangVien> {

    @Query("select p from PhanCongGiangVien p where p.keHoachMoMon.id = ?1 and p.giangVien.maCB = ?2")
    Optional<PhanCongGiangVien> findByGiangVienAndKeHoach(Long idKeHoach, Long maCb);

    @Query("select p from PhanCongGiangVien p where p.keHoachMoMon.id = ?1")
    List<PhanCongGiangVien> findByKeHoachMoMon(Long idKeHoach);
}
