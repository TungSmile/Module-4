package com.example.service;



import com.example.entity.Invoice;

import java.util.List;

public interface IInvoiceService {
    List<Invoice> getAllProduct();
    void save(Invoice e);
    void delete(Invoice e);
    Invoice finByID(int id);
}
