package com.zzin.realfinal.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class OrderInfo {
    private int id;

    private UserInfo user;

    private LocalDateTime date;
}
