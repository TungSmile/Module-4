package com.example.repository;

import com.example.entity.Comment;
import com.example.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Integer> {
    Optional<List<Comment>> findAllByProduct(Product product);
}
