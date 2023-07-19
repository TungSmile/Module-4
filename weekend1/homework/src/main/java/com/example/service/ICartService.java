package com.example.service;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;

import java.util.List;

public interface ICartService {
    List<Product> getAllProductInCart(User e);
    void save(Cart e);
    void delete(Cart e);
    Cart finByID(int id);
    Cart findByIDUser(int id);
    void addProductToCart(int idCart ,int idProduct);
    List<Product> findProductsById(int id);
    List<Product> getAllProductByIDCart(int id);
}
