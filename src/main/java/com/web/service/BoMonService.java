package com.web.service;

import com.web.entity.BoMon;
import com.web.entity.Nganh;
import com.web.repository.BoMonRepository;
import com.web.repository.NganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoMonService {

    @Autowired
    private BoMonRepository boMonRepository;

    public List<BoMon> findAll(){
        return boMonRepository.findAll();
    }
}
