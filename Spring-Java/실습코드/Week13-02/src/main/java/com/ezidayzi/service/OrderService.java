package com.ezidayzi.service;

import com.ezidayzi.model.OrderProductInfo;
import com.ezidayzi.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderProductRepository repository;

    public OrderService() {
        this.repository = new OrderProductRepository();
    }

    public void add(OrderProductInfo orderProductInfo) {
        repository.map.put(orderProductInfo.getId(), orderProductInfo);
    }

    public OrderProductInfo get(String id) {
        return repository.map.get(id);
    }
}
