package com.dinesh.lms.model;

public class Books {

	private int book_Id;
	private String title;
	private String author;
	private String category;
	private int quantity;
	@Override
	public String toString() {
		return "Books [book_Id=" + book_Id + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", quantity=" + quantity + "]";
	}
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
