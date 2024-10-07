package com.web.dto.response;

import com.web.entity.KeHoachMoMon;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class KeHoachMoMonSpecification implements Specification<KeHoachMoMon> {

    private String maKhoaHoc;

    private Long idNamHoc;

    private Long maHP;

    public KeHoachMoMonSpecification(String maKhoaHoc, Long idNamHoc, Long maHP) {
        this.maKhoaHoc = maKhoaHoc;
        this.idNamHoc = idNamHoc;
        this.maHP = maHP;
    }


    @Override
    public Predicate toPredicate(Root<KeHoachMoMon> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        if (maKhoaHoc != null) {
            predicate = cb.and(predicate, cb.equal(root.get("khoaHoc").get("maKhoaHoc"), maKhoaHoc));
        }
        if (idNamHoc != null) {
            predicate = cb.and(predicate, cb.equal(root.get("namHoc").get("id"), idNamHoc));
        }
        if (maHP != null) {
            predicate = cb.and(predicate, cb.equal(root.get("hocPhan").get("maHP"), maHP));
        }
        return predicate;
    }
}
