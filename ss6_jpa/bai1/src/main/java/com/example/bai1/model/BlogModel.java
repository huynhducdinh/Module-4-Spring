package com.example.bai1.model;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
@EntityListeners(AuditingEntityListener.class)
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titles",columnDefinition = "VARCHAR(50)" ,nullable = false)

    private String titles;
    @Column(name = "contents",columnDefinition = "TEXT" ,nullable = false)

    private String contents;
    @Column(name = "author",columnDefinition = "VARCHAR(50)" ,nullable = false)

    private String author;
    @Column(name = "day_create", updatable = false,columnDefinition = "DATETIME" ,nullable = false)
    @UpdateTimestamp
    private LocalDateTime dayCreate;
    @Column(name = "day_update",columnDefinition = "DATETIME" )
    @UpdateTimestamp
    private LocalDateTime dayUpdate;

    public BlogModel() {
    }

    public BlogModel(String titles, String contents, String author) {
        this.titles = titles;
        this.contents = contents;
        this.author = author;

    }

    public BlogModel(Integer id, String titles, String contents, String author, LocalDateTime dayCreate, LocalDateTime dayUpdate) {
        this.id = id;
        this.titles = titles;
        this.contents = contents;
        this.author = author;
        this.dayCreate = dayCreate;
        this.dayUpdate = dayUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDayCreate() {
        return dayCreate;
    }

    public void setDayCreate(LocalDateTime dayCreate) {
        this.dayCreate = dayCreate;
    }

    public LocalDateTime getDayUpdate() {
        return dayUpdate;
    }

    public void setDayUpdate(LocalDateTime dayUpdate) {
        this.dayUpdate = dayUpdate;
    }
}
