package com.example.bai1.model;

import javax.persistence.*;

@Entity
public class ProductShopp {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private  Double price;
    @Column(name = "description",columnDefinition = "TEXT")
    private  String description;
    @Column(name = "image",columnDefinition = "TEXT", nullable = false)
    private  String image;


    public ProductShopp(Integer id, String name, Double price, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public ProductShopp() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
