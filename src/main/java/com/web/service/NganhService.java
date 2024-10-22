package com.web.service;

import com.web.entity.Nganh;
import com.web.repository.NganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NganhService {

    @Autowired
    private NganhRepository nganhRepository;

    public List<Nganh> findAll(){
        return nganhRepository.findAll();
    }
}
