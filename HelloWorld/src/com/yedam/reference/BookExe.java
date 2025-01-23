package com.yedam.reference;

/*
 * <<도서명, 저자, 출판사, 판매가격 >>
 */
import java.util.Scanner;

public class BookExe {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Book[] bookRepository = new Book[100];

		// 1.전체목록 2.도서등록 3,조회(출판사) 9.종료

		while (run) {
			System.out.println("1.전체목록 2.도서등록 3.조회(출판사) 9.종료");
			System.out.print("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 전체목록
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] != null) {
						

					}
				}
				break;
			case 2: // 도서등록
				for(int i = 0; i < bookRepository.length; i++) {
					if(bookRepository[i] == null) {
						System.out.println("등록할 도서를 입력해주세요");
						bookRepository[i].bookName = scn.nextLine();
						
					}
				}
				break;
			}

		}
	} // end of main.
}
