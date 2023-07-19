package com.example.repository;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICartRepoitory extends PagingAndSortingRepository<Cart, Integer> {

    Cart findCartByClient_Id(int id);
    // viết ra mà méo hiểu gì luôn
    List<Product> findProductsByClientContains(User user);
    // containg với tham số nguyên thủy và contains với tham số đối tượng
    List<Product> findProductsById(int id);
}
