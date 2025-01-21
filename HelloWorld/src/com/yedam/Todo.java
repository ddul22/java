package com.yedam;

import java.util.Scanner;

// com.yedam.Todo 원래이름은 패키지와 클래스 더해서 클래스이름
public class Todo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //
		int balance = 0; // 예금액.

		System.out.println("1.입금 2.출금 3.잔액조회 4.종료"); //
		System.out.print("메뉴를 선택하세요> ");
		int num = Integer.parseInt(scn.nextLine()); // 어떤 값을 읽어들일때 scn.nextLine(), 문자타입으로 반환하겠습니다. 문자를 숫자타입으로
													// 바꾸겠다(Integer.parseInt)

		if (num == 1) { // 입금.
			System.out.print("입금액을 입력> ");
			balance = Integer.parseInt(scn.nextLine());

		} else if (num == 2) { // 출금.
			System.out.printf("현재 잔액은 %d입니다.\n", balance);
		} else if (num == 3) { // 잔액조회.

		} else if (num == 4) { // 종료13.

		}
		System.out.printf("end of prog\n"); //
	}
}