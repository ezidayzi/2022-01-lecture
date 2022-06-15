package com.ezidayzi.service;

import com.ezidayzi.model.ProductInfo;
import com.ezidayzi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService() {
        this.repository = new ProductRepository();
    }

    public HashMap<Integer, ProductInfo> getAllProducts() {
        return repository.map;
    }

    public ProductInfo get(int id) {
        return repository.map.get(id);
    }

    public List<ProductInfo> searchWithName(String keyword) {
        List<ProductInfo> result = new ArrayList<>();

        for (ProductInfo productInfo: repository.map.values()) {
            if (productInfo.getName().contains(keyword)){
                result.add(productInfo);
            }
        }

        return result;
    }

}
