package com.example.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ManyToOne
    private User client;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Product> product;


    public Cart(int id, User client, List<Product> product) {
        this.id = id;
        this.client = client;
        this.product = product;
    }

    public Cart(User client, List<Product> product) {
        this.client = client;
        this.product = product;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }


}
