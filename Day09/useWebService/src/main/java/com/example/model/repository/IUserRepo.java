package com.example.model.repository;

import com.example.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.jws.soap.SOAPBinding;

public interface IUserRepo extends PagingAndSortingRepository<User,Integer> {
}
