package com.web.repository;

import com.web.entity.KeHoachMoMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KeHoachMoMonRepository extends JpaRepository<KeHoachMoMon,Long>, JpaSpecificationExecutor<KeHoachMoMon> {
}
