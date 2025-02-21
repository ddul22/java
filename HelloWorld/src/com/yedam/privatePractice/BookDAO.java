package com.yedam.privatePractice;

import java.util.List;

/*
 * 등록, 수정, 삭제, 조회.
 */
public interface BookDAO {
	// 등록.
	public boolean registerBook(Book book);
	
	// 수정.
	public boolean modifyBook(Book book);
	
	// 삭제.
	public boolean removeBook(int bookNo);
	
	// 조회.
	public List<Book> search(Book book);

}
