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

    @Query("select g.boMon.tenBoMon from GiangVien g where g.user.id = ?1")
    String boMonCuaToi(Long userId);

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

    @Query("select g from GiangVien g where g.boMon.id = ?1")
    List<GiangVien> findByBoMon(Long boMonId);

    @Query("select g from GiangVien g where g.boMon.id = ?1")
    Page<GiangVien> findByBoMon(Long boMonId, Pageable pageable);

    @Query("select g from GiangVien g where g.boMon.id = ?1 and g.user.authorities.name = ?2")
    GiangVien getTruongBoMon(Long boMonId, String authorName);

    @Query(value = "select sum(\n" +
            "    COALESCE(\n" +
            "        (select sum((hp.so_tiet_ly_thuyet + hp.so_tiet_thuc_hanh) * pc.so_nhom)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         where pc.giang_vien_id = ?1 and pc.loai_nhom = 'ALL' and kc.nam_hoc_id = ?2), 0)\n" +
            "    +\n" +
            "    COALESCE(\n" +
            "        (select sum(hp.so_tiet_ly_thuyet * pc.so_nhom)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         where pc.giang_vien_id = ?1 and pc.loai_nhom = 'LT' and kc.nam_hoc_id = ?2), 0)\n" +
            "    +\n" +
            "    COALESCE(\n" +
            "        (select sum(hp.so_tiet_thuc_hanh * pc.so_nhom)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         where pc.giang_vien_id = ?1 and pc.loai_nhom = 'TH' and kc.nam_hoc_id = ?2), 0)\n" +
            ") as tong;\n", nativeQuery = true)
    Double tinhTongSoTiet(Long idGiangVien, Long idHocKy);


    @Query(value = "select sum(\n" +
            "    COALESCE(\n" +
            "        (select sum((hp.so_tiet_ly_thuyet + hp.so_tiet_thuc_hanh) * pc.so_nhom * hp.he_so)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         where pc.giang_vien_id = ?1 and pc.loai_nhom = 'ALL' and kc.nam_hoc_id = ?2), 0)\n" +
            "    +\n" +
            "    COALESCE(\n" +
            "        (select sum(hp.so_tiet_ly_thuyet * pc.so_nhom * hp.he_so)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         where pc.giang_vien_id = ?1 and pc.loai_nhom = 'LT' and kc.nam_hoc_id = ?2), 0)\n" +
            "    +\n" +
            "    COALESCE(\n" +
            "        (select sum(hp.so_tiet_thuc_hanh * pc.so_nhom * hp.he_so)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         where pc.giang_vien_id = ?1 and pc.loai_nhom = 'TH' and kc.nam_hoc_id = ?2), 0)\n" +
            ") as tong;\n", nativeQuery = true)
    Double tinhTongSoTietThucTe(Long idGiangVien, Long idHocKy);

    @Query("select count(g.id) from GiangVien g where g.dangHopDong = ?1")
    Long demByLoaiHopDong(String loaiHopDong);


    @Query(value = "select sum(\n" +
            "    COALESCE(\n" +
            "        (select sum((hp.so_tiet_ly_thuyet + hp.so_tiet_thuc_hanh) * pc.so_nhom * hp.he_so)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         inner join giang_vien gv on gv.id = pc.giang_vien_id\n" +
            "         where gv.dang_hop_dong = ?1 and pc.loai_nhom = 'ALL' and kc.nam_hoc_id = ?2), 0)\n" +
            "    +\n" +
            "    COALESCE(\n" +
            "        (select sum(hp.so_tiet_ly_thuyet * pc.so_nhom * hp.he_so)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         inner join giang_vien gv on gv.id = pc.giang_vien_id\n" +
            "          where gv.dang_hop_dong = ?1 and pc.loai_nhom = 'LT' and kc.nam_hoc_id = ?2), 0)\n" +
            "    +\n" +
            "    COALESCE(\n" +
            "        (select sum(hp.so_tiet_thuc_hanh * pc.so_nhom * hp.he_so)\n" +
            "         from phan_cong_giang_vien pc\n" +
            "         inner join ke_hoach_chi_tiet kc on kc.id = pc.ke_hoach_chi_tiet_id\n" +
            "         inner join hoc_phan hp on hp.id = kc.hoc_phan_id\n" +
            "         inner join giang_vien gv on gv.id = pc.giang_vien_id\n" +
            "         where gv.dang_hop_dong = ?1 and pc.loai_nhom = 'TH' and kc.nam_hoc_id = ?2), 0)\n" +
            ") as tong;\n", nativeQuery = true)
    Double tinhTongSoTiet(String loaiHopDong, Long idHocKy);
}
