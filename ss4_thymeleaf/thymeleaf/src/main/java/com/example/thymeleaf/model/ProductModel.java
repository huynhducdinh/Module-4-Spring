package com.example.thymeleaf.model;

public class ProductModel {
    private Integer id;
    private  String name;
    private Double price;
    private  String describe;

    public ProductModel(Integer id, String name, Double price, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public ProductModel() {
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
