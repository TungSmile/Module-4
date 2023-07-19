package com.example.repository;

import com.example.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface IIvoiceRpository extends CrudRepository<Invoice,Integer> {
}
