package com.assignment.books.dto;

import java.time.Year;
import java.util.Date;

/**
 * @author SUDHANSHU
 *
 */
public class BookDTO {
	private Long bookId;
	private String language;
	private String title;
	private String category;
	private String isbn;
	private String numberOfPages;
	private int year;
	private String auther;
	private String publisher;
	private String releaseDate;
	private String price;
	
	
	
	
	/**
	 *  super constructor
	 */
	public BookDTO() {
	
	}
	public BookDTO(String language,String title, String category, String isbn, String numberOfPages, Year year, String auther,
			String publisher, String releaseDate, String price) {
		super();
		this.language=language;
		this.title = title;
		this.category = category;
		this.isbn = isbn;
		this.numberOfPages = numberOfPages;
		this.auther = auther;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
		this.price = price;
	}
	
	
	/**
	 * @return getLanguage
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param set the language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the BOOKID
	 */
	public Long getBookId() {
		return bookId;
	}
	/**
	 * @param sets the  bookId
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return getTitle
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param  settitle
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return getCategory
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return getIsbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return getNumberOfPages
	 */
	public String getNumberOfPages() {
		return numberOfPages;
	}
	/**
	 * @param numberOfPages
	 */
	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	/**
	 * @return getAuther
	 */
	public String getAuther() {
		return auther;
	}
	/**
	 * @param auther
	 */
	public void setAuther(String auther) {
		this.auther = auther;
	}
	/**
	 * @return getPublisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return getReleaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param releaseDate
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * @return getPrice
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return getYear
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
