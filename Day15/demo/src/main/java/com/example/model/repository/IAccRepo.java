package com.example.model.repository;

import com.example.model.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IAccRepo extends PagingAndSortingRepository<Account, Integer> {

    //    User findUserByPasswordAndId_user(String Password, String Id_user);
    @Query("select u from Account u where u.userName=:UserName  and u.password=:Password")
    Account findUserByPasswordAndId_user(@Param("UserName") String UserName, @Param("Password") String Password);

    Account getAccountByUserName(String UserName);
}
