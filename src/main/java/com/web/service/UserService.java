package com.web.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.web.dto.response.CustomUserDetails;
import com.web.dto.request.TokenDto;
import com.web.dto.response.UserDto;
import com.web.entity.Authority;
import com.web.entity.User;
import com.web.exception.MessageException;
import com.web.jwt.JwtTokenProvider;
import com.web.mapper.UserMapper;
import com.web.repository.AuthorityRepository;
import com.web.repository.UserRepository;
import com.web.utils.CommonPage;
import com.web.utils.Contains;
import com.web.utils.MailService;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public TokenDto loginWithGoogle(GoogleIdToken.Payload payload) throws Exception {
        Optional<User> users = userRepository.findByEmail(payload.getEmail());
        // check infor user
        if (users.isPresent()) {
            if (users.get().getActived() == false) {
                throw new MessageException("Tài khoản đã bị khóa");
            }
            CustomUserDetails customUserDetails = new CustomUserDetails(users.get());
            String token = jwtTokenProvider.generateToken(customUserDetails);
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            tokenDto.setUser(userMapper.userToUserDto(users.get()));
            return tokenDto;
        } else {
            throw new MessageException("Đăng nhập thất bại");
        }
    }


    public TokenDto login(String email, String password) throws Exception {
        Optional<User> users = userRepository.findByUsername(email);
        // check infor user
        checkUser(users);
        if(passwordEncoder.matches(password, users.get().getPassword())){
            CustomUserDetails customUserDetails = new CustomUserDetails(users.get());
            String token = jwtTokenProvider.generateToken(customUserDetails);
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            tokenDto.setUser(userMapper.userToUserDto(users.get()));
            return tokenDto;
        }
        else{
            throw new MessageException("Mật khẩu không chính xác", 400);
        }
    }


    public User addAccount(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(exist->{
                    throw new MessageException("Email đã được sử dụng", 400);
                });
        String pass = user.getPassword();
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActived(true);
        User result = userRepository.save(user);
        mailService.sendEmail(user.getEmail(),"Mật khẩu của bạn","Mật khẩu truy cập của bạn là: "+pass,false, true);
        return result;
    }

    public Boolean checkUser(Optional<User> users){
        if(users.isPresent() == false){
            throw new MessageException("Không tìm thấy tài khoản", 404);
        }
        else if(users.get().getActived() == false){
            throw new MessageException("Tài khoản đã bị khóa", 500);
        }
        return true;
    }

    public void changePass(String oldPass, String newPass) {
        User user = userUtils.getUserWithAuthority();
        if(passwordEncoder.matches(oldPass, user.getPassword())){
            user.setPassword(passwordEncoder.encode(newPass));
            userRepository.save(user);
        }
        else{
            throw new MessageException("Invalid password", 500);
        }
    }

    public void forgotPassword(String email) {
        Optional<User> users = userRepository.findByEmail(email);
        // check infor user
        checkUser(users);
        String randomPass = userUtils.randomPass();
        users.get().setPassword(passwordEncoder.encode(randomPass));
        userRepository.save(users.get());
        mailService.sendEmail(email, "Quên mật khẩu","Cảm ơn bạn đã tin tưởng và xử dụng dịch vụ của chúng tôi:<br>" +
                "Chúng tôi đã tạo một mật khẩu mới từ yêu cầu của bạn<br>" +
                "Tuyệt đối không được chia sẻ mật khẩu này với bất kỳ ai. Bạn hãy thay đổi mật khẩu ngay sau khi đăng nhập<br><br>" +
                "<a style=\"background-color: #2f5fad; padding: 10px; color: #fff; font-size: 18px; font-weight: bold;\">"+randomPass+"</a>",false, true);

    }

    public void guiYeuCauQuenMatKhau(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        checkUser(user);
        String random = userUtils.randomKey();
        user.get().setRememberKey(random);
        userRepository.save(user.get());

        mailService.sendEmail(email, "Đặt lại mật khẩu","Cảm ơn bạn đã tin tưởng và xử dụng dịch vụ của chúng tôi:<br>" +
                "Chúng tôi đã tạo một mật khẩu mới từ yêu cầu của bạn<br>" +
                "Hãy lick vào bên dưới để đặt lại mật khẩu mới của bạn<br><br>" +
                "<a href='http://localhost:8080/datlaimatkhau?email="+email+"&key="+random+"' style=\"background-color: #2f5fad; padding: 10px; color: #fff; font-size: 18px; font-weight: bold;\">Đặt lại mật khẩu</a>",false, true);

    }

    public void xacNhanDatLaiMatKhau(String email, String password, String key) {
        Optional<User> user = userRepository.findByEmail(email);
        checkUser(user);
        if(user.get().getRememberKey().equals(key)){
            user.get().setPassword(passwordEncoder.encode(password));
            userRepository.save(user.get());
        }
        else{
            throw new MessageException("Mã xác thực không chính xác");
        }
    }

    public Page<User> getUserByRole(String search, String role, Pageable pageable) {
        Page<User> page = null;
        if(role != null){
            page = userRepository.getUserByRole(search,role, pageable);
        }
        else{
            page = userRepository.findAll(search,pageable);
        }
        return page;
    }
}
