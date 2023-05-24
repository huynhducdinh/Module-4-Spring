package com.example.bai1.model;

import javax.persistence.*;

@Entity
public class ProductModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
        @Column(name = "name_product",columnDefinition = "VARCHAR(50)")
    private String name;
    private Double price;
    private String describes;

    public ProductModel() {
    }

    public ProductModel(String name, Double price, String describes) {
        this.name = name;
        this.price = price;
        this.describes = describes;
    }

    public ProductModel(Integer id, String name, Double price, String describes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describes = describes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}