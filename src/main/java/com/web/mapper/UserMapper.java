package com.web.mapper;

import com.web.dto.request.UserRequest;
import com.web.dto.response.UserDto;
import com.web.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public UserDto userToUserDto(User user){
        UserDto dto = mapper.map(user, UserDto.class);
        return dto;
    }

    public User userRequestToUser(UserRequest request){
        User user = mapper.map(request, User.class);
        return user;
    }

    public List<UserDto> listUserToListUserDto(List<User> list){
        List<UserDto> dto = list.stream().map(post -> mapper.map(post, UserDto.class))
                .collect(Collectors.toList());
        return dto;
    }

}
