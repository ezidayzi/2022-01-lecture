package com.ezidayzi.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductInfo {
    private int id;

    private String name;

    private String info;

    private int price;

    public ProductInfo(int id, String name, String info, int price) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                '}';
    }
}
