package com.web.service;

import com.web.dto.response.GiangVienSoTiet;
import com.web.entity.GiangVien;
import com.web.entity.KeHoachChiTiet;
import com.web.entity.NamHoc;
import com.web.entity.PhanCongGiangVien;
import com.web.enums.LoaiNhom;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.KeHoachChiTietRepository;
import com.web.repository.NamHocRepository;
import com.web.repository.PhanCongGiangVienRepository;
import com.web.utils.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhanCongGiangVienService {

    @Autowired
    private PhanCongGiangVienRepository phanCongGiangVienRepository;

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private NamHocRepository namHocRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private KeHoachChiTietRepository keHoachChiTietRepository;

    public List<PhanCongGiangVien> findByKeHoach(Long keHoachCtId){
        List<PhanCongGiangVien> list = phanCongGiangVienRepository.findByKeHoachCt(keHoachCtId);
        return list;
    }

    public PhanCongGiangVien save(PhanCongGiangVien phanCongGiangVien){
        if(phanCongGiangVienRepository.findByGiangVienAndKeHoachAndLoaiNhom(phanCongGiangVien.getKeHoachChiTiet().getId(),
                phanCongGiangVien.getGiangVien().getId(), phanCongGiangVien.getLoaiNhom()).isPresent()){
            throw new MessageException("Giảng viên đã được thêm, không thể thêm lại");
        }
        GiangVien giangVien = giangVienRepository.findById(phanCongGiangVien.getGiangVien().getId()).get();
        phanCongGiangVien.setGiangVien(giangVien);
        KeHoachChiTiet keHoachChiTiet = keHoachChiTietRepository.findById(phanCongGiangVien.getKeHoachChiTiet().getId()).get();
        phanCongGiangVien.setKeHoachChiTiet(keHoachChiTiet);
        if (keHoachChiTiet.getLocked() != null){
            if(keHoachChiTiet.getLocked() == true){
                throw new MessageException("Kế hoạch đã bị khóa");
            }
        }
        Integer numNhomAll = phanCongGiangVienRepository.tongNhomByLoaiNhom(LoaiNhom.ALL, keHoachChiTiet.getId());
        Integer numNhomTH = phanCongGiangVienRepository.tongNhomByLoaiNhom(LoaiNhom.TH, keHoachChiTiet.getId());
        Integer numNhomLT = phanCongGiangVienRepository.tongNhomByLoaiNhom(LoaiNhom.LT, keHoachChiTiet.getId());
        if(numNhomAll == null) numNhomAll = 0;
        if(numNhomTH == null) numNhomTH = 0;
        if(numNhomLT == null) numNhomLT = 0;

        if(phanCongGiangVien.getLoaiNhom().equals(LoaiNhom.ALL)){
            numNhomAll += phanCongGiangVien.getSoNhom();
        }
        if(phanCongGiangVien.getLoaiNhom().equals(LoaiNhom.TH)){
            numNhomTH += phanCongGiangVien.getSoNhom();
        }
        if(phanCongGiangVien.getLoaiNhom().equals(LoaiNhom.LT)){
            numNhomLT += phanCongGiangVien.getSoNhom();
        }
        if(numNhomLT == numNhomTH){
            numNhomAll += numNhomLT;
        }
        if(numNhomLT < numNhomTH){
            numNhomAll += numNhomTH;
        }
        if(numNhomLT > numNhomTH){
            numNhomAll += numNhomLT;
        }
        if(numNhomAll > keHoachChiTiet.getTongSoNhom()){
            throw new MessageException("Tổng số nhóm không được vượt quá "+keHoachChiTiet.getTongSoNhom());
        }
        phanCongGiangVien.setNgayCapNhat(LocalDateTime.now());
        phanCongGiangVienRepository.save(phanCongGiangVien);
        if(!giangVien.getDangHopDong().equals("Cơ hữu")){
            sendPhieuMoiGiang(phanCongGiangVien);
        }
        return phanCongGiangVien;
    }

    public PhanCongGiangVien update(Long id, Integer soNhom, LoaiNhom loaiNhom) {
        PhanCongGiangVien pc = phanCongGiangVienRepository.findById(id).get();
        if(phanCongGiangVienRepository.findByGiangVienAndKeHoachAndLoaiNhomAndId(pc.getKeHoachChiTiet().getId(),
                pc.getGiangVien().getId(), loaiNhom, id).isPresent()){
            throw new MessageException("Giảng viên đã được thêm, không thể thêm lại");
        }
        KeHoachChiTiet keHoachChiTiet = pc.getKeHoachChiTiet();
        if (pc.getKeHoachChiTiet().getLocked() != null){
            if(keHoachChiTiet.getLocked() == true){
                throw new MessageException("Kế hoạch đã bị khóa");
            }
        }
        Integer numNhomAll = phanCongGiangVienRepository.tongNhomByLoaiNhom(LoaiNhom.ALL, keHoachChiTiet.getId());
        Integer numNhomTH = phanCongGiangVienRepository.tongNhomByLoaiNhom(LoaiNhom.TH, keHoachChiTiet.getId());
        Integer numNhomLT = phanCongGiangVienRepository.tongNhomByLoaiNhom(LoaiNhom.LT, keHoachChiTiet.getId());
        if(pc.getLoaiNhom().equals(LoaiNhom.TH)){
            numNhomTH -= pc.getSoNhom();
        }
        if(pc.getLoaiNhom().equals(LoaiNhom.LT)){
            numNhomLT -= pc.getSoNhom();
        }
        if(pc.getLoaiNhom().equals(LoaiNhom.ALL)){
            numNhomAll -= pc.getSoNhom();
        }
        if(numNhomAll == null) numNhomAll = 0;
        if(numNhomTH == null) numNhomTH = 0;
        if(numNhomLT == null) numNhomLT = 0;

        if(loaiNhom.equals(LoaiNhom.ALL)){
            numNhomAll += soNhom;
        }
        if(loaiNhom.equals(LoaiNhom.TH)){
            numNhomTH += soNhom;
        }
        if(loaiNhom.equals(LoaiNhom.LT)){
            numNhomLT += soNhom;
        }
        if(numNhomLT == numNhomTH){
            numNhomAll += numNhomLT;
        }
        if(numNhomLT < numNhomTH){
            numNhomAll += numNhomTH;
        }
        if(numNhomLT > numNhomTH){
            numNhomAll += numNhomLT;
        }
        if(numNhomAll > keHoachChiTiet.getTongSoNhom()){
            throw new MessageException("Tổng số nhóm không được vượt quá "+keHoachChiTiet.getTongSoNhom());
        }
        pc.setSoNhom(soNhom);
        pc.setLoaiNhom(loaiNhom);
        pc.setNgayCapNhat(LocalDateTime.now());
        phanCongGiangVienRepository.save(pc);
        return pc;
    }

    public void delete(Long id){
        PhanCongGiangVien phanCongGiangVien = phanCongGiangVienRepository.findById(id).get();
        KeHoachChiTiet keHoachChiTiet = phanCongGiangVien.getKeHoachChiTiet();
        if (keHoachChiTiet.getLocked() != null){
            if(keHoachChiTiet.getLocked() == true){
                throw new MessageException("Kế hoạch đã bị khóa");
            }
        }
        try {
            phanCongGiangVienRepository.deleteById(id);
        }
        catch (Exception e){
            throw new MessageException("Không thể xóa do đã có liên kết");
        }
    }

    public Page<PhanCongGiangVien> phanCongCuaToi(Pageable pageable, Long idNamHoc) {
        Page<PhanCongGiangVien> page=  null;
        GiangVien giangVien = giangVienService.thongTinCuaToi();
        if(idNamHoc == null){
            page = phanCongGiangVienRepository.findByGiangVien(giangVien.getId(), pageable);
        }
        else{
            page = phanCongGiangVienRepository.findByGiangVienAndNamHoc(giangVien.getId(), idNamHoc, pageable);
        }
        return page;
    }

    public void phanHoi(String noiDung, Long id){
        PhanCongGiangVien phanCongGiangVien = phanCongGiangVienRepository.findById(id).get();
        phanCongGiangVien.setPhanHoi(noiDung);
        phanCongGiangVien.setNgayPhanHoi(LocalDateTime.now());
        phanCongGiangVienRepository.save(phanCongGiangVien);
        GiangVien truongBoMon = giangVienService.getTruongBoMon(phanCongGiangVien.getKeHoachChiTiet().getHocPhan().getBoMon().getId());
        mailService.sendEmail(truongBoMon.getUser().getEmail(), "Phản hồi lịch phân công",
                "Lịch dạy học phần "+phanCongGiangVien.getKeHoachChiTiet().getHocPhan().getTenHP()+" đã được phản hổi bời giảng viên "+
                        phanCongGiangVien.getGiangVien().getTenGV()
                ,false, true);
    }

    public void traLoiphanHoi(String noiDung, Long id){
        PhanCongGiangVien phanCongGiangVien = phanCongGiangVienRepository.findById(id).get();
        phanCongGiangVien.setTraLoiPhanHoi(noiDung);
        phanCongGiangVien.setNgayTraLoiPhanHoi(LocalDateTime.now());
        phanCongGiangVienRepository.save(phanCongGiangVien);
        mailService.sendEmail(phanCongGiangVien.getGiangVien().getUser().getEmail(), "Phản hồi lịch phân công",
                "Lịch dạy học phần "+phanCongGiangVien.getKeHoachChiTiet().getHocPhan().getTenHP()+" đã được trả lời phản hồi, hãy truy cập vào website để xem "
                ,false, true);
    }

    public void sendPhieuMoiGiang(PhanCongGiangVien p){
        String loaiNhom = p.getLoaiNhom().toString();
        if (loaiNhom.equals("ALL")) loaiNhom = "TL + TH";
        LocalDate now = LocalDate.now();
        String noiDung =
                "<div style=\"border: 1px solid black; padding: 20px;\">\n" +
                "        <div style=\"display: flex; margin-bottom: 20px;\">\n" +
                "            <div style=\"width: 50%; text-align: center;\">\n" +
                "                <h3 style=\"margin: 0; font-size: 18px; font-weight: 400;\">ỦY BAN NHÂN DÂN</h3>\n" +
                "                <h3 style=\"margin: 0; font-size: 18px; font-weight: 400;\">THÀNH PHỐ HỒ CHÍ MINH</h3>\n" +
                "                <h3 style=\"margin: 0; font-size: 18px;\">TRƯỜNG ĐẠI HỌC CÔNG NGHIỆP TPHCM</h3>\n" +
                "            </div>\n" +
                "            <div style=\"width: 50%; text-align: center;\">\n" +
                "                <h3 style=\"margin: 0; font-size: 18px; font-weight: 400;\">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</h3>\n" +
                "                <strong style=\"margin: 0; font-size: 18px;\">Độc lập - tự do - Hạnh phúc</strong>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <h2 style=\"text-align: center; margin: 20px 0; font-size: 20px;\">PHIẾU MỜI GIẢNG "+p.getKeHoachChiTiet().getNamHoc().getHocKy()+" năm học "+p.getKeHoachChiTiet().getNamHoc().getTenNamHoc()+"</h2>\n" +
                "\n" +
                "        <div style=\"margin-bottom: 20px;\">\n" +
                "            <p>Khoa: <strong>Công nghệ Thông tin</strong></p>\n" +
                "            <p>Mời Giảng Viên: "+p.getGiangVien().getTenGV()+"<span style=\"margin-left: 100px;\">Mã số CBGV: "+p.getGiangVien().getMaCB()+"</span></p>\n" +
                "            <p>Học vị, chức danh: "+p.getGiangVien().getChucDanh()+"</p>\n" +
                "            <p>Hướng tới theo kế hoạch sau:</p>\n" +
                "        </div>\n" +
                "\n" +
                "        <table style=\"width: 100%; border-collapse: collapse; text-align: center;\">\n" +
                "            <thead>\n" +
                "                <tr>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">STT</th>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">Tên Học phần</th>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">Mã HP</th>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">Số TC</th>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">Số tiết của HP</th>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">Số lượng lớp/nhóm</th>\n" +
                "                    <th style=\"border: 1px solid black; padding: 5px;\">Giảng dạy ở HK</th>\n" +
                "                </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">1</td>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getTenHP()+"</td>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getMaHP()+"</td>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getSoTinChi()+"</td>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getTongSoTiet()+"</td>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">"+p.getSoNhom()+" nhóm "+loaiNhom+"</td>\n" +
                "                    <td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getNamHoc().getHocKy()+" - "+p.getKeHoachChiTiet().getNamHoc().getTenNamHoc()+"</td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "\n" +
                "        <div style=\"margin-top: 20px; text-align: right;\">\n" +
                "            <p>Thành phố Hồ Chí Minh, ngày "+now.getDayOfMonth()+" tháng "+now.getMonthValue()+" năm "+now.getYear()+"</p>\n" +
                "            <p><strong>Trưởng Đơn vị</strong></p>\n" +
                "        </div>\n" +
                "    </div>";
        mailService.sendEmail(p.getGiangVien().getUser().getEmail(), "Phiếu mời giảng",noiDung, false, true);
    }

    public void sendMailMoiGiang(Long namHocId) {
        List<GiangVien> giangVienMoiGiang = giangVienRepository.findByLoaiHopDong("Mời giảng");
        List<GiangVien> giangVienThinhGiang = giangVienRepository.findByLoaiHopDong("Thỉnh giảng");
        NamHoc namHoc = namHocRepository.findById(namHocId).get();
        for(GiangVien g : giangVienMoiGiang){
            List<PhanCongGiangVien> list = phanCongGiangVienRepository.findByGiangVienAndNamHoc(g.getId(), namHocId);
            if(list.size() > 0){
                System.out.println("===================================================");
                System.out.println("giang vien moi giang: "+ g.getUser().getEmail());
                sendListPhieuMoiGiang(list, g,"Phiếu Mời Giảng", namHoc);
            }
        }
        for(GiangVien g : giangVienThinhGiang){
            List<PhanCongGiangVien> list = phanCongGiangVienRepository.findByGiangVienAndNamHoc(g.getId(), namHocId);
            if(list.size() > 0){
                System.out.println("===================================================");
                System.out.println("giang vien thinh giang: "+ g.getUser().getEmail());
                sendListPhieuMoiGiang(list, g,"Phiếu Thính Giảng", namHoc);
            }
        }
    }


    public void sendListPhieuMoiGiang(List<PhanCongGiangVien> list, GiangVien g, String loaiPhieu, NamHoc namHoc){
        LocalDate now = LocalDate.now();
        String noiDung =
                "<div style=\"border: 1px solid black; padding: 20px;\">\n" +
                        "        <div style=\"display: flex; margin-bottom: 20px;\">\n" +
                        "            <div style=\"width: 50%; text-align: center;\">\n" +
                        "                <h3 style=\"margin: 0; font-size: 18px; font-weight: 400;\">ỦY BAN NHÂN DÂN</h3>\n" +
                        "                <h3 style=\"margin: 0; font-size: 18px; font-weight: 400;\">THÀNH PHỐ HỒ CHÍ MINH</h3>\n" +
                        "                <h3 style=\"margin: 0; font-size: 18px;\">TRƯỜNG ĐẠI HỌC CÔNG NGHIỆP TPHCM</h3>\n" +
                        "            </div>\n" +
                        "            <div style=\"width: 50%; text-align: center;\">\n" +
                        "                <h3 style=\"margin: 0; font-size: 18px; font-weight: 400;\">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</h3>\n" +
                        "                <strong style=\"margin: 0; font-size: 18px;\">Độc lập - tự do - Hạnh phúc</strong>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <h2 style=\"text-align: center; margin: 20px 0; font-size: 20px;\">" +loaiPhieu+" " +namHoc.getHocKy()+" năm học "+namHoc.getTenNamHoc()+"</h2>\n" +
                        "\n" +
                        "        <div style=\"margin-bottom: 20px;\">\n" +
                        "            <p>Khoa: <strong>Công nghệ Thông tin</strong></p>\n" +
                        "            <p>Mời Giảng Viên: "+g.getTenGV()+"<span style=\"margin-left: 100px;\">Mã số CBGV: "+g.getMaCB()+"</span></p>\n" +
                        "            <p>Học vị, chức danh: "+g.getChucDanh()+"</p>\n" +
                        "            <p>Hướng tới theo kế hoạch sau:</p>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <table style=\"width: 100%; border-collapse: collapse; text-align: center;\">\n" +
                        "            <thead>\n" +
                        "                <tr>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">STT</th>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">Tên Học phần</th>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">Mã HP</th>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">Số TC</th>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">Số tiết của HP</th>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">Số lượng lớp/nhóm</th>\n" +
                        "                    <th style=\"border: 1px solid black; padding: 5px;\">Giảng dạy ở HK</th>\n" +
                        "                </tr>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n";
                        Integer stt = 0;
                        for(PhanCongGiangVien p : list){
                            ++stt;
                            String loaiNhom = p.getLoaiNhom().toString();
                            if (loaiNhom.equals("ALL")) loaiNhom = "TL + TH";
                            noiDung += "<tr>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+stt+"</td>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getTenHP()+"</td>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getMaHP()+"</td>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getSoTinChi()+"</td>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getHocPhan().getTongSoTiet()+"</td>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+p.getSoNhom()+" nhóm "+loaiNhom+"</td>\n" +
                                    "<td style=\"border: 1px solid black; padding: 5px;\">"+p.getKeHoachChiTiet().getNamHoc().getHocKy()+" - "+p.getKeHoachChiTiet().getNamHoc().getTenNamHoc()+"</td>\n" +
                                    "</tr>\n";
                        }
                        noiDung += "            </tbody>\n" +
                        "        </table>\n" +
                        "\n" +
                        "        <div style=\"margin-top: 20px; text-align: right;\">\n" +
                        "            <p>Thành phố Hồ Chí Minh, ngày "+now.getDayOfMonth()+" tháng "+now.getMonthValue()+" năm "+now.getYear()+"</p>\n" +
                        "            <p><strong>Trưởng Đơn vị</strong></p>\n" +
                        "        </div>\n" +
                        "    </div>";
        mailService.sendEmail(g.getUser().getEmail(), loaiPhieu,noiDung, false, true);
    }
}
