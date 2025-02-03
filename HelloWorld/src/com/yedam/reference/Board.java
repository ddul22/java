package com.yedam.reference;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 게시글제목, 내용, 작성자, 작성일시(2025-02-01).
 */
public class Board {
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	
	// 생성자 정의.
	public Board(String title, String content, String writer, Date writeDate ) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	
	// getter, setter. 메소드
	public void setTitle(String title) { // 필드 지정
		this.title = title; 
	}
	
	public String getTitle() { // 값 불러오기
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	// showBoard() 각각 필드 반환하는 메소드
	public String showBoard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return title +" "+content+" "+writer+" "+writeDate;
	}
}

