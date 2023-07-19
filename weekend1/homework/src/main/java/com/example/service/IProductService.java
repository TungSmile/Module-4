package com.example.service;

import com.example.entity.Product;
import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    void save(Product e);
    void delete(Product e);
    Product finByID(int id);

}
