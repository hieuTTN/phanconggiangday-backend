package com.web.repository;

import com.web.entity.HocKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HocKyRepository extends JpaRepository<HocKy, Long> {


}
