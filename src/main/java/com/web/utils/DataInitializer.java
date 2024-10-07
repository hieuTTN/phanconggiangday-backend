package com.web.utils;

import com.web.entity.User;
import com.web.repository.AuthorityRepository;
import com.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String password = "admin";
        String email = "admin@gmail.com";

        // Kiểm tra xem tài khoản đã tồn tại chưa
        if (!userRepository.findByUsername(email).isPresent()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setActived(true);
            user.setCreatedDate(new Date(System.currentTimeMillis()));
            user.setFullName("ADMIN");
//            user.setAuthorities(authorityRepository.findByName(Contains.ROLE_ADMIN));
            // Nếu cần mã hóa mật khẩu, bạn có thể làm ở đây
            userRepository.save(user);
        }
    }
}
