package com.example.service.impl;

import com.example.entity.Comment;
import com.example.repository.ICommentRepository;
import com.example.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;

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
}
