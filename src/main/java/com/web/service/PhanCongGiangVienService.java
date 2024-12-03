package com.web.service;

import com.web.dto.response.GiangVienSoTiet;
import com.web.entity.GiangVien;
import com.web.entity.KeHoachChiTiet;
import com.web.entity.PhanCongGiangVien;
import com.web.enums.LoaiNhom;
import com.web.exception.MessageException;
import com.web.repository.GiangVienRepository;
import com.web.repository.KeHoachChiTietRepository;
import com.web.repository.PhanCongGiangVienRepository;
import com.web.utils.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        if(phanCongGiangVienRepository.findByGiangVienAndKeHoach(phanCongGiangVien.getKeHoachChiTiet().getId(),
                phanCongGiangVien.getGiangVien().getId()).isPresent()){
            throw new MessageException("Giảng viên đã được thêm, không thể thêm lại");
        }
       KeHoachChiTiet keHoachChiTiet = keHoachChiTietRepository.findById(phanCongGiangVien.getKeHoachChiTiet().getId()).get();
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
        return phanCongGiangVien;
    }

    public PhanCongGiangVien update(Long id, Integer soNhom, LoaiNhom loaiNhom) {
        PhanCongGiangVien pc = phanCongGiangVienRepository.findById(id).get();
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


}
