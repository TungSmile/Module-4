package com.example.repository;

import com.example.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Integer> {

}
