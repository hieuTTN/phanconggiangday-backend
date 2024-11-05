package com.web.repository;

import com.web.entity.KhoaHoc;
import com.web.enums.TrangThaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Long> {

    @Query("select k from KhoaHoc k where k.trangThaiKhoaHoc = ?1")
    List<KhoaHoc> khoaHocChuaKetThuc(TrangThaiKhoaHoc dangHoc);
}
