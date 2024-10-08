package com.web.dto.response;

import com.web.entity.KeHoachMoMon;
import com.web.entity.PhanCongGiangVien;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PhanCongGiangVienSpecification implements Specification<PhanCongGiangVien> {

    private String maKhoaHoc;

    private Long idNamHoc;

    private Long maHP;

    private Long maCb;

    public PhanCongGiangVienSpecification(String maKhoaHoc, Long idNamHoc, Long maHP, Long maCb) {
        this.maKhoaHoc = maKhoaHoc;
        this.idNamHoc = idNamHoc;
        this.maHP = maHP;
        this.maCb = maCb;
    }

    @Override
    public Predicate toPredicate(Root<PhanCongGiangVien> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        if (maKhoaHoc != null) {
            predicate = cb.and(predicate, cb.equal(root.get("keHoachMoMon").get("khoaHoc").get("maKhoaHoc"), maKhoaHoc));
        }
        if (idNamHoc != null) {
            predicate = cb.and(predicate, cb.equal(root.get("keHoachMoMon").get("namHoc").get("id"), idNamHoc));
        }
        if (maHP != null) {
            predicate = cb.and(predicate, cb.equal(root.get("keHoachMoMon").get("hocPhan").get("maHP"), maHP));
        }
        if (maCb != null) {
            predicate = cb.and(predicate, cb.equal(root.get("giangVien").get("maCB"), maCb));
        }
        return predicate;
    }
}
