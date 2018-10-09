package com.assignment.books.model;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author SUDHANSHU
 *
 */
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5797163917197932857L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	private String language;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "ISBN")
	private String isbn;
	@Column(name = "NUMBEROFPAGES")
	private String numberOfPages;
	@Column(name = "YEAR")
	private int year;
	@Column(name = "AUTHER")
	private String auther;
	@Column(name = "PUBLISHER")
	private String publisher;

	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	
	@Column(name = "PRICE")
	private String price;

	public Book() {

	}

	public Book(Long id, String title, String category, String isbn, String numberOfPages, Year year, String auther,
			String publisher, Date releaseDate, String price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.isbn = isbn;
		this.numberOfPages = numberOfPages;
		this.auther = auther;
		this.publisher = publisher;
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
