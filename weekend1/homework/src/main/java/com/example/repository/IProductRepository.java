package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProductRepository extends PagingAndSortingRepository<Product,Integer> {

}
