package com.js.dto;

public class Book {
	private int bookid;
	private String bookname;
	private String authorname;
	private int Pages;
	private double Price;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int i) {
		this.bookid = i;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public int getPages() {
		return Pages;
	}
	public void setPages(int pages) {
		Pages = pages;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	
	
	
	

}
