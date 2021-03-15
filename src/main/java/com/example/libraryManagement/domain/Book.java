package com.example.libraryManagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISBN")
	private String ISBN;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "checkout_flag", nullable = false, columnDefinition = "boolean default 'false'")
	private boolean checkOutFlag;
	  
	@Column(name = "return_flag", nullable = false, columnDefinition = "boolean default 'false'")
	private boolean returnFlag;
	  
    @Column(name = "checkout_date", nullable = false, columnDefinition = "int default '0'")
	private int checkOutDate;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isCheckOutFlag() {
		return checkOutFlag;
	}

	public void setCheckOutFlag(boolean checkOutFlag) {
		this.checkOutFlag = checkOutFlag;
	}

	public boolean isReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(boolean returnFlag) {
		this.returnFlag = returnFlag;
	}

	public int getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(int checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", count=" + count + ", checkOutFlag="
				+ checkOutFlag + ", returnFlag=" + returnFlag + ", checkOutDate=" + checkOutDate + "]";
	}



	
}
