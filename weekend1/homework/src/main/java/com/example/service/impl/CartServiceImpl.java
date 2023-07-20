package com.example.service.impl;

import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.repository.ICartRepoitory;
import com.example.repository.IProductRepository;
import com.example.repository.IUserRepository;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    ICartRepoitory iCartRepoitory;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IProductRepository iProductRepository;

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
        User user = iUserRepository.findById(idUser).get();
        Product product = iProductRepository.findById(idProduct).get();
        List<Product> list;
        if (cart == null) {
            list = new ArrayList<>();
            list.add(product);
            save(new Cart(user, list));
        } else {
            list = cart.getProduct();
            list.add(product);
            cart.setProduct(list);
            save(cart);
        }
    }

    @Override
    public void removeProductOnCart(int idUser, int idProduct) {
        Cart cart = findByIDUser(idUser);
        List<Product> list=  cart.getProduct();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==idProduct){
                list.remove(i);
                break;
            }
        }
        cart.setProduct(list);
        save(cart);
    }

//    @Override
//    public List<Product> findProductsByIdUser(int id) {
//        // by id user
//        return getAllProductInCart(iUserRepository.findById(id).get());
//    }
//
//    @Override
//    public List<Product> getAllProductByIDCart(int id) {
//        return iCartRepoitory.findProductsById(id);
//    }
}
