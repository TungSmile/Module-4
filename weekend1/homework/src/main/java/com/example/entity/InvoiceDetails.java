package com.example.entity;

import javax.persistence.*;

@Entity
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @ManyToOne
    private Invoice invoice;
    @ManyToOne
    private Product product;
    private int quality;
    private double total;

    public InvoiceDetails(int id, Invoice invoice, Product product, int quality, double total) {
        this.id = id;
        this.invoice = invoice;
        this.product = product;
        this.quality = quality;
        this.total = total;
    }

    public InvoiceDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
