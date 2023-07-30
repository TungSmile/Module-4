package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepo extends PagingAndSortingRepository<Account, Integer> {
    Account getAccountByAccountName(String AccountName);
}
