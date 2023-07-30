package com.example.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_create;
    private String commentOfClient;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne
    private Product product;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentOfClient() {
        return commentOfClient;
    }

    public void setCommentOfClient(String commentOfClient) {
        this.commentOfClient = commentOfClient;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
