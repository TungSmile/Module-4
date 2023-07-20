package com.example.repository;

import com.example.entity.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IIvoiceRpository extends PagingAndSortingRepository<Invoice,Integer> {
}
