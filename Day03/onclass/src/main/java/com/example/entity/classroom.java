package com.example.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class classroom {
    @Id
    private int id;
    private String class_name;

    public classroom() {
    }

    public classroom(int id, String class_name) {
        this.id = id;
        this.class_name = class_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
