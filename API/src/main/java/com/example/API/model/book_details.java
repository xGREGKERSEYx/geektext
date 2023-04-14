package com.example.API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_details")
public class book_details {
	
	@Column
	String description;
	@Column
	int year_published;
	@Column
	int copies_sold;
	@Column
	int rating;
	@Column
	double price;
	@Column
	double discount_price;
	@Column
	String comments;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	int book_id_fk;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear_published() {
		return year_published;
	}
	public void setYear_published(int year_published) {
		this.year_published = year_published;
	}
	public int getCopies_sold() {
		return copies_sold;
	}
	public void setCopies_sold(int copies_sold) {
		this.copies_sold = copies_sold;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(double discount_price) {
		this.discount_price = discount_price;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getBook_id_fk() {
		return book_id_fk;
	}
	public void setBook_id_fk(int book_id_fk) {
		this.book_id_fk = book_id_fk;
	}
	public book_details(String description, int year_published, int copies_sold, int rating, double price,
			double discount_price, String comments, int book_id_fk) {
		super();
		this.description = description;
		this.year_published = year_published;
		this.copies_sold = copies_sold;
		this.rating = rating;
		this.price = price;
		this.discount_price = discount_price;
		this.comments = comments;
		this.book_id_fk = book_id_fk;
	}
	public book_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "book_details [description=" + description + ", year_published=" + year_published + ", copies_sold="
				+ copies_sold + ", rating=" + rating + ", price=" + price + ", discount_price=" + discount_price
				+ ", comments=" + comments + ", book_id_fk=" + book_id_fk + "]";
	}
	
	
	
	
}
