package com.example.bai1.model;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codeName;
    private  boolean status;
    @OneToOne
    @JoinColumn(name = "id_book")
    private Book book;

    public Borrow() {
    }

    public Borrow(Integer id, Integer codeName, boolean status, Book book) {
        this.id = id;
        this.codeName = codeName;
        this.status = status;
        this.book = book;
    }

    public Borrow(Integer codeName, boolean status, Book book) {
        this.codeName = codeName;
        this.status = status;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeName() {
        return codeName;
    }

    public void setCodeName(Integer codeName) {
        this.codeName = codeName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
