package com.web.service;

import com.web.entity.BoMon;
import com.web.entity.HocKy;
import com.web.repository.BoMonRepository;
import com.web.repository.HocKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocKyService {

    @Autowired
    private HocKyRepository hocKyRepository;

    public List<HocKy> findAll(){
        return hocKyRepository.findAll();
    }
}
