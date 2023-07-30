package com.example.model.repository;

import com.example.model.entity.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICartRepo  extends PagingAndSortingRepository<Cart,Integer> {
}
