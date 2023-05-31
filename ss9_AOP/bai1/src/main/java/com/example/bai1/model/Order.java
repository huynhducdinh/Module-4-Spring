package com.example.bai1.model;


    import javax.persistence.*;

@Entity
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String code;
        private int bookId;

        @ManyToOne
        @JoinColumn(name = "book_id", referencedColumnName = "id")
        private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Order(int id, String code, int bookId, Book book) {
        this.id = id;
        this.code = code;
        this.bookId = bookId;
        this.book = book;
    }

    public Order() {
        }

        public Order(int id, String code, int bookId) {
            this.id = id;
            this.code = code;
            this.bookId = bookId;
        }

        public Order(String code, int bookId) {
            this.code = code;
            this.bookId = bookId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }
    }
