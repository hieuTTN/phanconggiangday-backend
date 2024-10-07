package com.web.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {

    private String oldPass;

    private String newPass;
}
