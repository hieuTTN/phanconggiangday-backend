package com.web.service;

import com.web.entity.BaiViet;
import com.web.exception.MessageException;
import com.web.repository.BaiVietRepository;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private UserUtils userUtils;


    public BaiViet save(BaiViet blog) {
        blog.setUser(userUtils.getUserWithAuthority());
        blog.setNgayTao(LocalDateTime.now());
        BaiViet result = baiVietRepository.save(blog);
        return result;
    }

    public void delete(Long id) {
        baiVietRepository.deleteById(id);
    }


    public BaiViet findById(Long id) {
        return baiVietRepository.findById(id).get();
    }

    public Page<BaiViet> findAll(Pageable pageable, String search) {
        if (search == null){
            search = "";
        }
        search = "%"+search+"%";
        Page<BaiViet> page = baiVietRepository.findByParam(search,pageable);
        return page;
    }

}
