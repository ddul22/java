package com.yedam.privatePractice;
/* 
 * 도서코드(A001)
 * 책제목(세이노의 가르침)
 * 작가(세이노)
 * 출판사(데이원)
 * 가격(7200)
 */
public class Book {
	private int bookNo;
	private String bookName;
	private String writer;
	private String publisher;
	private int price;
	
	public Book() {
		
	}
	
	public Book(int bookNo, String bookName, String writer, String publisher, int price) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String bookInfo() {
		// 코드번호     제목        작가     출판사    가격
		// -----------------------------------------
		// A001   세이노의 가르침   세이노    데이원    7200
		return bookNo + " " + bookName + " " + writer + " " + publisher + " " + price;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}
