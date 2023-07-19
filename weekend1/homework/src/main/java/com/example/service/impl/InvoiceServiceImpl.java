package com.example.service.impl;

import com.example.entity.Invoice;
import com.example.repository.IIvoiceRpository;
import com.example.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IIvoiceRpository iIvoiceRpository;

    @Override
    public List<Invoice> getAllProduct() {
        return (List<Invoice>) iIvoiceRpository.findAll();
    }

    @Override
    public void save(Invoice e) {
        iIvoiceRpository.save(e);
    }

    @Override
    public void delete(Invoice e) {
        iIvoiceRpository.delete(e);
    }

    @Override
    public Invoice finByID(int id) {
        return iIvoiceRpository.findById(id).get();
    }
}
