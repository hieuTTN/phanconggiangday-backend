package com.web.service;

import com.web.dto.request.ChiTietHocRequest;
import com.web.entity.ChiTietHoc;
import com.web.entity.HocPhan;
import com.web.entity.KeHoachHoc;
import com.web.repository.ChiTietHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChiTietHocService {

    @Autowired
    private ChiTietHocRepository chiTietHocRepository;

    public List<ChiTietHoc> saveList(ChiTietHocRequest request){
        List<ChiTietHoc> list = new ArrayList<>();
        for(Long id : request.getListIdHocPhan()){
//            Optional<ChiTietHoc> ex = chiTietHocRepository.findByHocPhanHocKyKhh(id, request.getHocKy().getId(), request.getKeHoachHoc().getId());
//            if(ex.isPresent()){
//                continue;
//            }
            ChiTietHoc chiTietHoc = new ChiTietHoc();
            chiTietHoc.setHocKy(request.getHocKy());
            chiTietHoc.setKeHoachHoc(request.getKeHoachHoc());
            HocPhan hocPhan = new HocPhan();
            hocPhan.setId(id);
            chiTietHoc.setHocPhan(hocPhan);
            chiTietHocRepository.save(chiTietHoc);
            list.add(chiTietHoc);
        }
        return list;
    }

    public void delete(Long id) {
        chiTietHocRepository.deleteById(id);
    }

    public ChiTietHoc findById(Long id) {
        return chiTietHocRepository.findById(id).get();
    }

    public Page<ChiTietHoc> findByKeHoachHocAndHocKy(Pageable pageable, Long hocKyId, Long keHoachHocId) {
        Page<ChiTietHoc> page = null;
        if(hocKyId == null){
            page = chiTietHocRepository.findByKeHoachHoc(keHoachHocId,pageable);
        }
        else if(hocKyId != null){
            page = chiTietHocRepository.findByKeHoachHocAndHocKy(keHoachHocId, hocKyId,pageable);
        }
        return page;
    }
}
