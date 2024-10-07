package com.web.service;

import com.web.entity.Authority;
import com.web.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}
