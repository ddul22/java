package com.yedam.privatePractice;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.yedam.interfaces.emp.Employee;

/*
 * 도서관리 실행클래스
 */

public class MainExe {

	static Scanner scn = new Scanner(System.in);

	static BookDAO dao = new BookListExe();

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.수정 3.삭제 4.조회 9.종료");
			System.out.println("선택>> ");
			int menu = 0;

			try {
				menu = scn.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 확인하세요");
				scn.nextLine();
				continue;
			}

			scn.nextLine();
			switch (menu) {
			case 1: // 등록
				int bookNo = 0;
				while (true) {
					System.out.println("도서코드번호 >> ");
					try {
						bookNo = Integer.parseInt(scn.nextLine());
						break;
					} catch (InputMismatchException e) {
						System.out.println("코드번호를 확인하세요");
					}
				System.out.print("제목>> ");
				String bookName = scn.nextLine();
				System.err.println("작가>> ");
				String writer = scn.nextLine();
				System.out.print("출판사>> ");
				String publisher = scn.nextLine();
				System.out.println("가격>> ");
				int price = scn.nextInt();
			
				if(dao.registerBook(new Book(bookNo, bookName, writer, publisher, price))) {
					System.out.println("등록성공");
				}
				break;
			}
			case 2: // 도서코드, 가격 수정
				System.out.println("도서코드>> ");
				bookNo = Integer.parseInt(scn.nextLine());
				System.out.println("가격");
				int price = scn.nextInt();
				if(price == 0 ) {
					price = 0;
				}
				break;
				
			case 3: // 삭제. 사원번호.
				try {
					remove();
				} catch (NumberFormatException e) {
					System.out.println("사원번호를 확인");
				}
				break;

			case 4: 
				System.out.println("조회 이름조건 >>");
				String bookName = scn.nextLine();
				Book book = new Book();
				book.setBookName(bookName);

				// 조회결과.
				List<Book> result = dao.search(book);
				// 출력.
				System.out.println("코드번호    제목     작가    출판사   가격");
				System.out.println("------------------------------------");
				for (Book book1 : result) {
					if (book1 != null) {
						System.out.println(book1.getBookNo() + "  " + book1.getBookName() + "  " + book1.getWriter() + "  "
								+ book1.getPublisher() + " " + book1.getPrice());
					}
				}
				break; // case 4.
			case 9:
				System.out.println("종료합니다");
				run = false;
				break; // case 9.
			default:
				System.out.println("메뉴를 확인하세요.");
			}
		} // end of while.
		System.out.println("end of prog");

	} // end of main.

	// 예외 떠넘기기 예제.
	static void remove() throws NumberFormatException {
		System.out.println("코드번호 >> ");
		int bookNo = Integer.parseInt(scn.nextLine());
		if (dao.removeBook(bookNo)) {
			System.out.println("삭제완료");
		}
	} // end of remove.
}
