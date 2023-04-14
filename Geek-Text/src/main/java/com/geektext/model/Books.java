package com.geektext.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    
    @Column(name = "book_name")
    private String book_title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Double price; 

    public Books(Long book_id, String book_title, String author, Double price) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.price = price;
    }

    public Books() {
        
    }

    public Long getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" + "book_id=" + book_id + ", book_title=" + book_title + ", author=" + author + ", price=" + price + '}';
    }
    
    
    
}