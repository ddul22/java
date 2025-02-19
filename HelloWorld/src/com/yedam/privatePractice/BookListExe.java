package com.yedam.privatePractice;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 */
public class BookListExe implements BookDAO {
	List<Book> bookList = new ArrayList<Book>();

	public BookListExe() {
		bookList.add(new Book(1001, "세이노의 가르침", "세이노", "데이원", 7200));
		bookList.add(new Book(1002, "소년이 온다", "창비", "데이원", 13500));
		bookList.add(new Book(1003, "채식주의자", "한강", "문학동네", 7200));
		bookList.add(new Book(1004, "작별하지 않는다", "한강", "문학동네", 7200));
		bookList.add(new Book(1005, "초역 부처의 말", "코이케 류노스케", "포레스트북스", 16020));
		bookList.add(new Book(1006, "모순", "양귀자", "쓰다", 11700));
		bookList.add(new Book(1007, "어른의 행복은 조용하다", "태수", "페이지2북스", 16020));
		bookList.add(new Book(1008, "급류", "정대건", "민음사", 12600));
	}

	@Override // 등록
	public boolean registerBook(Book book) {
		return bookList.add(book);
	}

	@Override // 도서코드, 가격 수정
	public boolean modifyBook(Book book) {

		for (int i = 0; i < bookList.size(); i++) {

			if (bookList.get(i).getBookNo() == book.getBookNo()) {
				if ((book.getBookNo() != 0)) {
					bookList.get(i).setBookNo(book.getBookNo());
				}
			}
			
			if(book.getPrice() != 0) {
				bookList.get(i).setPrice(book.getPrice());
			}
			return true;
		}
		return false;
	}

	@Override // 삭제
	public boolean removeBook(int bookNo) {
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getBookNo() == bookNo) {
				bookList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override // 조회
	public List<Book> search(Book book) {
		List<Book> result = new ArrayList<Book>();
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).getBookName().indexOf(book.getBookName()));
			if(bookList.get(i).getBookName().indexOf(book.getBookName())!=-1) {
				result.add(bookList.get(i));
			}
			if(bookList.get(i).getPrice() >= book.getPrice()) {
				result.add(bookList.get(i));
			}
		}
		return result;
	}

}
