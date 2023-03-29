package com.example.API.model;

public class books {
	
	String title;
	String author;
	String publisher;
	String genre;
	String sub_genre;
	String ISBN;
	int book_id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSub_genre() {
		return sub_genre;
	}
	public void setSub_genre(String sub_genre) {
		this.sub_genre = sub_genre;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public books(String title, String author, String publisher, String genre, String sub_genre, String iSBN,
			int book_id) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.sub_genre = sub_genre;
		ISBN = iSBN;
		this.book_id = book_id;
	}
	
	public books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "books [title=" + title + ", author=" + author + ", publisher=" + publisher + ", genre=" + genre
				+ ", sub_genre=" + sub_genre + ", ISBN=" + ISBN + ", book_id=" + book_id + "]";
	}
	
	
}
