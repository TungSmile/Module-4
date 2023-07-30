package com.example.model.repository;

import com.example.model.entity.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IInvoiceRepo extends PagingAndSortingRepository<Invoice,Integer> {
}
