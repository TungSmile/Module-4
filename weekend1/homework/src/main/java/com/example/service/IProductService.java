package com.example.service;

import com.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    void save(Product e);
    void delete(Product e);
    Product finByID(int id);
    Page<Product> getAllProduct(Pageable pageable);
}
