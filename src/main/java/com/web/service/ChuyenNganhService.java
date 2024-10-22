package com.web.service;

import com.web.entity.ChuyenNganh;
import com.web.exception.MessageException;
import com.web.repository.ChuyenNganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenNganhService {

    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    public List<ChuyenNganh> findAll(){
        return chuyenNganhRepository.findAll();
    }

    public List<ChuyenNganh> findByMaNganh(String maNganh){
        return chuyenNganhRepository.findByNganh(maNganh);
    }

    public ChuyenNganh create(ChuyenNganh chuyenNganh){
        chuyenNganhRepository.save(chuyenNganh);
        return chuyenNganh;
    }

    public void delete(String ma){
        try {
            chuyenNganhRepository.deleteById(ma);
        }
        catch (Exception e){
            throw new MessageException("Không thể xóa chuyên ngành này");
        }
    }
}
