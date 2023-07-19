package com.example.service;


import com.example.entity.InvoiceDetails;

import java.util.List;

public interface IInvoiceDetailService {
    List<InvoiceDetails> getAllProduct();
    void save(InvoiceDetails e);
    void delete(InvoiceDetails e);
    InvoiceDetails finByID(int id);
}
