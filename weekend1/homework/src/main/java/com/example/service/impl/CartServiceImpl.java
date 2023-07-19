package com.example.service.impl;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.repository.ICartRepoitory;
import com.example.repository.IUserRepository;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    ICartRepoitory iCartRepoitory;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<Product> getAllProductInCart(User e) {
        return iCartRepoitory.findProductsByClientContains(e);
    }
    @Override
    public void save(Cart e) {
        iCartRepoitory.save(e);
    }

    @Override
    public void delete(Cart e) {
        iCartRepoitory.delete(e);
    }

    @Override
    public Cart finByID(int id) {
        return iCartRepoitory.findById(id).get();
    }

    @Override
    public Cart findByIDUser(int id) {
        return iCartRepoitory.findCartByClient_Id(id);
    }

    @Override
    public void addProductToCart(int idUser, int idProduct) {
        Cart cart = findByIDUser(idUser);
    }
    @Override
    public List<Product> findProductsById(int id) {
        return getAllProductInCart(iUserRepository.findById(id).get());
    }

    @Override
    public List<Product> getAllProductByIDCart(int id) {
        return iCartRepoitory.findProductsById(id);
    }
}
