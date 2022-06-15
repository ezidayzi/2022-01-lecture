package com.ezidayzi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
public class UserInfo {

    @NotNull(message="필수 항목입니다.")
    private String userid;

    @NotNull(message="필수 항목입니다.")
    private String pwd;

    @NotNull(message="필수 항목입니다.")
    private String addr;

    @NotNull(message="필수 항목입니다.")
    @Email(message="잘못된 이메일 형식입니다.")
    private String email;

    @NotNull(message="필수 항목입니다.")
    private String tel;

    @NotNull(message="필수 항목입니다.")
    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDate birthday;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid='" + userid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", addr='" + addr + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
