package com.example.service.impl;

import com.example.entity.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void save(Product e) {
        productRepository.save(e);
    }
    @Override
    public void delete(Product e) {
        productRepository.delete(e);
    }

    @Override
    public Product finByID(int id) {
        return productRepository.findById(id).get();
    }

    public Page<Product> getAllProduct(Pageable pageable){
        return productRepository.findAll(pageable);
    }
}
