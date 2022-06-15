package com.ezidayzi.repository;

import com.ezidayzi.model.ProductInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {
    public HashMap<Integer, ProductInfo> map = new HashMap<>();

    public ProductRepository() {
        map.put(1,new ProductInfo(1, "김치찌개", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(2,new ProductInfo(2, "김치찌개2", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(3,new ProductInfo(3, "김치찌개3", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(4,new ProductInfo(4, "김치찌개4", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(5,new ProductInfo(5, "김치찌개5", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(6,new ProductInfo(6, "김치찌개6", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(7,new ProductInfo(7, "김치찌개7", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(8,new ProductInfo(8, "김치찌개8", "대한민국에서 제일 맛있는 김치찌개", 7000));
        map.put(9,new ProductInfo(9, "김치찌개9", "대한민국에서 제일 맛있는 김치찌개", 7000));
    }
}
