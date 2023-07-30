package com.example.model.repository;

import com.example.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepo extends PagingAndSortingRepository<Product,Integer> {
}
