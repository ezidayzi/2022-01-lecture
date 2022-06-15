package com.ezidayzi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrderProductInfo {
    private String id;

    private int count;

    private int orderPrice;

    private UserInfo user;

    private List<ProductInfo> products;
}
