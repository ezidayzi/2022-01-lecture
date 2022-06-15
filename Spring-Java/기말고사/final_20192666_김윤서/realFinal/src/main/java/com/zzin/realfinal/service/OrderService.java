package com.zzin.realfinal.service;

import com.zzin.realfinal.model.OrderProductInfo;
import com.zzin.realfinal.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderProductRepository repository;

    OrderService() {
        this.repository = new OrderProductRepository();
    }

    public void add(OrderProductInfo orderProductInfo) {
        repository.map.put(orderProductInfo.getId(), orderProductInfo);
    }

    public OrderProductInfo get(String id) {
        return repository.map.get(id);
    }
}
