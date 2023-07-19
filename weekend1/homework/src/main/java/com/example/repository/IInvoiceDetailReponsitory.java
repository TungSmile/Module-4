package com.example.repository;

import com.example.entity.InvoiceDetails;
import org.springframework.data.repository.CrudRepository;

public interface IInvoiceDetailReponsitory extends CrudRepository<InvoiceDetails,Integer> {
}
