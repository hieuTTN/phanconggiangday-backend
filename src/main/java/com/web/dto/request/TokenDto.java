package com.web.dto.request;

import com.web.dto.response.UserDto;
import com.web.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {

    private String token;

    private UserDto user;
}
