package com.example.service.impl;

import com.example.entity.Comment;
import com.example.entity.Product;
import com.example.repository.ICommentRepository;
import com.example.repository.IProductRepository;
import com.example.repository.IUserRepository;
import com.example.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<Comment> getAllProduct() {
        return (List<Comment>) iCommentRepository.findAll();
    }

    @Override
    public void save(Comment e) {
        iCommentRepository.save(e);
    }

    @Override
    public void delete(Comment e) {
        iCommentRepository.delete(e);
    }

    @Override
    public Comment finByID(int id) {
        return iCommentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getAllProductFromProduct(int idProduct) {
        Product product= iProductRepository.findById(idProduct).get();
        List<Comment> list= iCommentRepository.findAllByProduct(product).get();
        return list;
    }

    @Override
    public void addNewComment(int idUser, int idProduct, String comment) {
        Comment temp=new Comment();
        temp.setCommentOfClient(comment);
        temp.setUser(iUserRepository.findById(idUser).get());
        temp.setProduct(iProductRepository.findById(idProduct).get());
        temp.setDate_create(new Date(System.currentTimeMillis()));
        iCommentRepository.save(temp);
    }
}
