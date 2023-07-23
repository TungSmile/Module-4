package com.example.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date day_create;
    @ManyToOne
    private User client;
    private double amount;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Product> productList;

    public Invoice(int id, Date day_create, User client, double amount,List<Product> productList) {
        this.id = id;
        this.day_create = day_create;
        this.client = client;
        this.amount = amount;
        this.productList=productList;
    }
    public Invoice() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDay_create() {
        return day_create;
    }

    public void setDay_create(Date day_create) {
        this.day_create = day_create;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
