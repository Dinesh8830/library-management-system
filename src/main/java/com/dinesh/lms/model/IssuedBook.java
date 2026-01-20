package com.dinesh.lms.model;

import java.sql.Date;

public class IssuedBook {

	private int issued_Id;
	private int book_Id;
	private String issuedTo;
	private Date issuedDate;
	
	public IssuedBook() {}
	
	public IssuedBook(int book_Id, String issuedTo, Date issuedDate)
	{
		this.book_Id = book_Id;
		this.issuedTo = issuedTo;
		this.issuedDate = issuedDate;
		
	}

	@Override
	public String toString() {
		return "IssuedBook [issued_Id=" + issued_Id + ", book_Id=" + book_Id + ", issuedTo=" + issuedTo
				+ ", issuedDate=" + issuedDate + "]";
	}

	public int getIssued_Id() {
		return issued_Id;
	}

	public void setIssued_Id(int issued_Id) {
		this.issued_Id = issued_Id;
	}

	public int getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
}
