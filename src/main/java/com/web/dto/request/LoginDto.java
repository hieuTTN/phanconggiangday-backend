package com.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private String email;

    private String password;

    private String tokenFcm;
}
