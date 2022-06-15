package com.ezidayzi.repository;

import com.ezidayzi.model.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderRepository {
    public HashMap<Integer, OrderInfo> map = new HashMap<>();
}
