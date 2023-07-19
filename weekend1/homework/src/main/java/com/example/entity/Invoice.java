package com.example.entity;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private Date day_create;
    // chưa có xử lý converter hoặc formatter
    @ManyToOne
    private User client;
    private double amount;

    public Invoice(int id, Date day_create, User client, double amount) {
        this.id = id;
        this.day_create = day_create;
        this.client = client;
        this.amount = amount;
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
}
