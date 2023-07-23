package com.example.service;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;

import java.util.List;

public interface ICartService {
    public List<Product> getAllProductInCart(User e);
    void save(Cart e);
    void delete(Cart e);
    Cart finByID(int id);
    Cart findByIDUser(int id);
    void addProductToCart(int idUser ,int idProduct);
    void removeProductOnCart(int idUser ,int idProduct);
    void changeCartToInvoice(int idUser);

//    public List<Product> findProductsByIdUser(int id);
//    public List<Product> getAllProductByIDCart(int id);
}
