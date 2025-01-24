package com.yedam.reference;

/*
 * <<도서명, 저자, 출판사, 판매가격 >>
 */
import java.util.Scanner;

public class BookExe {
	static Book[] bookRepository = new Book[100];
	static void init() {
		// 초기데이터.
		bookRepository[0] = new Book("이것이자바다", "신용권", "한빛미디어", 30000);
		bookRepository[1] = new Book("자바스크립트기초", "김기초", "한빛미디어", 20000);
		bookRepository[2] = new Book("혼자공부하는자바", "김기초", "자바출판사", 20000);		
	}// end of init()
	// 목록출력.
	public static void printList() {
		System.out.println("도서명             저자      가격");
		System.out.println("======================================");
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null) {
				System.out.println(bookRepository[i].showBookInfo());
			}
		}
		System.out.println("======================================");
	} // end of printList()
	
	static Scanner scn = new Scanner(System.in);
	// 도서등록.
	public static void addBook() {
		System.out.print("도서명 입력>>");
		String bookName = scn.nextLine();
		System.out.print("저자 입력>>");
		String writer = scn.nextLine();
		System.out.print("출판사 입력>>");
		String publisher = scn.nextLine();
		System.out.print("가격 입력>>");
		int price = Integer.parseInt(scn.nextLine());

		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] == null) {
				bookRepository[i] = new Book(bookName, writer, publisher, price);
				System.out.println("도서등록완료");
				break; // for 종료.
			}
		}
	} // end of addBook()

	// 목록(출판사)
	public static void searchList() {
		System.out.println("출판사입력");
		String publisher = scn.nextLine();
		System.out.println("도서명                  저자      가격");
		System.out.println("=====================================");
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && bookRepository[i].getPublisher().equals(publisher)) {
				System.out.println(bookRepository[i].showBookInfo());
			}
		}
		System.out.println("=====================================");
	} // end of searchList()
	
	public static void modifyBook() {
		System.out.print("도서명 입력>>");
	    String bookName = scn.nextLine();
		System.out.print("가격 입력>>");
		int price = Integer.parseInt(scn.nextLine());
		// 도서명으로 검색 => 입력값으로 필드변경.
		boolean isExist = false; // 
		for(int i = 0; i < bookRepository.length; i++) {
			if(bookRepository[i]!= null && bookRepository[i].getBookName() .equals(bookName)) {
				bookRepository[i].setPrice(price);
				System.out.println("수정완료.");
				isExist = true;
				break; // 수정완료되면 반복문 종료.
			}
		} // end of for.
		if(!isExist) {
			System.out.println("찾는 도서가 없습니다.");					
		}
	}
	public static void detailBook() {
		System.out.print("도서명 입력>>");
	    String bookName = scn.nextLine();
	    Calculator cal = new Calculator();
	    cal.getBookInfo(bookName, bookRepository).showDetailInfo();
//	    for (int i = 0; i < bookRepository.length; i++) {
//	    	if(bookRepository[i] != null && bookRepository[i].getBookName().equals(bookName)) {
//	    		bookRepository[i].showDetailInfo(); // 상세출력.
//	    		break;
//	    	}
//	    }
	    System.out.println("======================================");
	}
	public static void main(String[] args) {
		init();
		boolean run = true;
		// 저장공간에 값을 초기값을 
		// 1.전체목록 2.도서등록 3,조회(출판사) 9.종료

		while (run) {
			System.out.println("1.전체목록 2.도서등록 3.조회(출판사) 4.가격수정 5.상세출력 9.종료");
			System.out.print("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 전체목록
				printList();
				break;

			case 2: // 도서등록
				addBook();
				break;
				
			case 3: // 조회(출판사)
			    searchList();
				break;
				
			case 4: //  수정.
				modifyBook();
				break;
				
			case 5: //  상세조회.
				detailBook();
				break;
				
			}// end of switch
		}
	}// end of main.
} // end of class
