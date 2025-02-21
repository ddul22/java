package com.yedam;

import java.util.Scanner;

// com.yedam.Todo 원래이름은 패키지와 클래스 더해서 클래스이름
public class Todo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); // 현재잔액 54000원 출금금액 마이너스 안되게 입금 10만원 안되게 
		int balance = 0; // 예금액.
		
		
		while (true) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료"); //
			System.out.print("메뉴를 선택하세요> ");
			int num = Integer.parseInt(scn.nextLine()); // 어떤 값을 읽어들일때 scn.nextLine(), 문자타입으로 반환하겠습니다. 문자를 숫자타입으로
			// 바꾸겠다(Integer.parseInt)
			
			if (num == 1) { // 입금.
				System.out.print("입금액을 입력> ");
				int in =Integer.parseInt(scn.nextLine());
				if (balance+in > 100000) {
					System.out.println("예금액을 100000원을 넘길 수 없습니다");
				}else {
				balance += in;
				System.out.printf("현재 입금액 %d원입니다. \n", in);
				}
				
			} else if (num == 2) { // 출금.
				System.out.print("출금액을 입력> ");
				int out = Integer.parseInt(scn.nextLine());
				if (balance-out < 0) {
					System.out.println("출금액이 현재 가지고 있는 잔액보다 많습니다");
				} else {
					balance -= out;
					System.out.printf("현재 출금액은 %d원입니다.\n", out);
				}
				
			} else if (num == 3) { // 잔액조회.
				System.out.printf("현재 잔액은 %d원입니다.\n", balance);
			} else if (num == 4) { // 종료.
				break;
			}
			
		}
		System.out.printf("end of prog\n"); //
	}
}