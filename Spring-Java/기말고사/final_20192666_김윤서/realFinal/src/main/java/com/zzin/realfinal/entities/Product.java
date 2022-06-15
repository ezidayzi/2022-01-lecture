package com.zzin.realfinal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Product {

    @Id @GeneratedValue
    @Column(name = "productId")
    private int id;

    private String name;

    private String info;

    private int price;

}
