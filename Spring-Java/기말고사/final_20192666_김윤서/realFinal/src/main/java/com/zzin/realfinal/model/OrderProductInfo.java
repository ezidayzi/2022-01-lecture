package com.zzin.realfinal.model;

import com.zzin.realfinal.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderProductInfo {
    private String id;

    private int count;

    private int orderPrice;

    private User user;

    private List<ProductInfo> products;

    @Override
    public String toString() {
        return "OrderProductInfo{" +
                "id='" + id + '\'' +
                ", count=" + count +
                ", orderPrice=" + orderPrice +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
