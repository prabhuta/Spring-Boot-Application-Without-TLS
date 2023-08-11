package com.mycompany.SpringBootCrud.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Best Book Reads\"")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String series;
	@Column(length = 1000)
	private String author;
	private String language;
	private String isbn;
	private String publisher;
	private int numRatings;
	private int likedPercent;
	private int bbeScore;
	private int bbeVotes;
	private int price;
	
	public Book() {
		
	}
	
public Book(int id, String title, String series, String author, String language, String isbn, String publisher,
			int numRatings, int likedPercent, int bbeScore, int bbeVotes, int price) {
		super();
		this.id = id;
		this.title = title;
		this.series = series;
		this.author = author;
		this.language = language;
		this.isbn = isbn;
		this.publisher = publisher;
		this.numRatings = numRatings;
		this.likedPercent = likedPercent;
		this.bbeScore = bbeScore;
		this.bbeVotes = bbeVotes;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getNumRatings() {
		return numRatings;
	}
	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}
	public int getLikedPercent() {
		return likedPercent;
	}
	public void setLikedPercent(int likedPercent) {
		this.likedPercent = likedPercent;
	}
	public int getBbeScore() {
		return bbeScore;
	}
	public void setBbeScore(int bbeScore) {
		this.bbeScore = bbeScore;
	}
	public int getBbeVotes() {
		return bbeVotes;
	}
	public void setBbeVotes(int bbeVotes) {
		this.bbeVotes = bbeVotes;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
