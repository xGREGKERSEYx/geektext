package com.geektext.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class ShoppingCart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GenerationType.IDENTITY, database system will automatically generate the primary key value
    private Long cart_item_id;
    
    @ManyToOne (fetch = FetchType.LAZY)//specifies how foreign key is mapped
    @JoinColumn(name = "user_id") //specifies name of foreign key and corresponding primary key
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY) //specifies how foreign key is mapped, only fetches it when accessed
    @JoinColumn(name = "book_id") //specifies name of foreign key and corresponding primary key
    private Books book;
    
    private int quantity;

    public ShoppingCart(Long cart_item_id, User user, Books book, int quantity) {
        this.cart_item_id = cart_item_id;
        this.user = user;
        this.book = book;
        this.quantity = quantity;
    }

    public ShoppingCart() {
        super();
    }

      

    public Long getCart_item_id() {
        return cart_item_id;
    }

    public Long getUser_id() {
        return user.getUser_id();
    }

    public Long getBook_id() {
        return book.getBook_id();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCart_item_id(Long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public void setUser_id(User user) {
        this.user = user;
        
    }

    public void setBook_id(Books book) {
        this.book = book;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "cart_item_id=" + cart_item_id + ", user_id=" + user.getUser_id() + ", book_id=" + book.getBook_id() + ", quantity=" + quantity + '}';
    }
    
   
    
}
