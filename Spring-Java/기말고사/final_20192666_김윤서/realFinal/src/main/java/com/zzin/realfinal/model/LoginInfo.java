package com.zzin.realfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginInfo {

    @NotEmpty(message="필수 항목입니다.")
    private String userid;

    @NotEmpty(message="필수 항목입니다.")
    private String pwd;

    private Boolean rememberId;

}
