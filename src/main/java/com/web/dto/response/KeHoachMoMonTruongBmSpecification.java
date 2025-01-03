package com.web.dto.response;

import com.web.entity.KeHoachMoMon;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class KeHoachMoMonTruongBmSpecification implements Specification<KeHoachMoMon> {

    Long hocKyId;

    Long idNamHoc;

    Long nganhId;

    Long khoaHocId;

    Long boMonId;


    public KeHoachMoMonTruongBmSpecification(Long hocKyId, Long idNamHoc, Long nganhId, Long khoaHocId, Long boMonId) {
        this.hocKyId = hocKyId;
        this.idNamHoc = idNamHoc;
        this.nganhId = nganhId;
        this.khoaHocId = khoaHocId;
        this.boMonId = boMonId;
    }

    @Override
    public Predicate toPredicate(Root<KeHoachMoMon> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        if (hocKyId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("hocKy").get("id"), hocKyId));
        }
        if (idNamHoc != null) {
            predicate = cb.and(predicate, cb.equal(root.get("namHoc").get("id"), idNamHoc));
        }
        if (nganhId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("nganh").get("id"), nganhId));
        }
        if (khoaHocId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("khoaHoc").get("id"), khoaHocId));
        }
        if (nganhId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("khoaHoc").get("id"), khoaHocId));
        }
        if (boMonId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("khoaHoc").get("id"), khoaHocId));
        }
        return predicate;
    }
}
