package com.zzin.realfinal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String userId;

    private String pwd;

    private String addr;

    private String email;

    private String tel;

    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + addr + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", birthday=" + birthday +
                ", orders=" + orders +
                '}';
    }
}
