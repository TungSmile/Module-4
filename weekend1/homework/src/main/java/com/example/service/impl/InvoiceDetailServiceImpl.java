package com.example.service.impl;

import com.example.entity.InvoiceDetails;
import com.example.repository.IInvoiceDetailReponsitory;
import com.example.service.IInvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements IInvoiceDetailService {
    @Autowired
    IInvoiceDetailReponsitory iInvoiceDetailReponsitory;

    @Override
    public List<InvoiceDetails> getAllProduct() {
        return (List<InvoiceDetails>) iInvoiceDetailReponsitory.findAll();
    }

    @Override
    public void save(InvoiceDetails e) {
        iInvoiceDetailReponsitory.save(e);
    }

    @Override
    public void delete(InvoiceDetails e) {
        iInvoiceDetailReponsitory.delete(e);
    }

    @Override
    public InvoiceDetails finByID(int id) {
        return iInvoiceDetailReponsitory.findById(id).get();
    }
}
