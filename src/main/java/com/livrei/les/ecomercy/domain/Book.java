package com.livrei.les.ecomercy.domain;


import jakarta.persistence.Entity;

@Entity
public class Book extends Product {

	private static final long serialVersionUID = 1L;
	public String author;
	public String releaseYear;
	public String publisher;
	public String isbn;
	public String totalPages;
	public Dimensions dimensions;
	
	
	public Book() {}
	
	public Book(Long id, String name, String description, Double price, String imgUrl, String barCode, Integer productStatus, String author, String releaseYear, String publisher, String isbn, String totalPages, Dimensions dimensions) {
		super(id, name, description, price, imgUrl, barCode, productStatus);
		this.author = author;
		this.releaseYear = releaseYear;
		this.publisher = publisher;
		this.isbn = isbn;
		this.totalPages = totalPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
