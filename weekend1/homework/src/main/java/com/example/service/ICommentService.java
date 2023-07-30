package com.example.service;

import com.example.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllProduct();
    void save(Comment e);
    void delete(Comment e);
    Comment finByID(int id);
    List<Comment> getAllProductFromProduct(int idProduct);
    void addNewComment(int idUser, int idProduct,String comment);
}
