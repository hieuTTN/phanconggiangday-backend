package com.web.dto.request;

import com.web.entity.Authority;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
public class UserRequest {

    private String email;

    private String password;

    private String fullName;

    private String avatar;

    private Authority authorities;

}
