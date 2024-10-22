package com.web.repository;

import com.web.entity.KeHoachMoMonNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface KeHoachMoMonNganhRepository extends JpaRepository<KeHoachMoMonNganh, Long> {

    @Modifying
    @Transactional
    @Query("delete from KeHoachMoMonNganh p where p.keHoachMoMon.id = ?1")
    int deleteByKeHoachMoMon(Long id);
}
