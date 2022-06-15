package com.ezidayzi.repository;

import com.ezidayzi.model.OrderProductInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderProductRepository {
    public HashMap<String, OrderProductInfo> map = new HashMap<>();
}
