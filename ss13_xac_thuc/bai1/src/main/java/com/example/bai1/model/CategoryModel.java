package com.example.bai1.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "category")
@EntityListeners(AuditingEntityListener.class)
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_category" ,columnDefinition = "VARCHAR(50)",nullable = false)
    private  String nameCategory;

   private boolean status;

    public CategoryModel() {
    }

    public CategoryModel(Integer id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
