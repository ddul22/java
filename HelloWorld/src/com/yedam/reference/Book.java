package com.yedam.reference;

public class Book {
	//필드.
	private String bookName;
	private String writer;
	private String publisher;
	private int price;
	// public, default, private => 접근제한자(access modifier)
	// 생성자.
	
	
	
	public Book(String bookName, String writer, String publisher, int price ) {
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	// 제목, 저자, 가격
	String showBookInfo() {
		return bookName + "  " + writer + "  " + publisher + "  " + price;
	}
	public void showDetailInfo() {
		// 도서명: 이것이 자바다    출판사: 한빛미디어
		// 저 자: 신용권          가 격: 25000 원
		String strFormat = " 도서명: %10s \t출판사: %6s\n 저 자: %3s\t\t가 격: %5d 원\n";
		System.out.printf(strFormat, writer, writer, publisher, price);
	}
	// setter.
	void setBookPrice(int price) {
		if(price < 0) {
			this.price = 0;
			return;
		}
		this.price = price;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//getter.
	public String getBookName() {
		return bookName;
	}
	public String getWriter() {
		return writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPrice() {
		return price;
	}
	
}

