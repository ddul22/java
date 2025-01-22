package com.yedam;

import java.util.Scanner;

public class ForLoop2c {  // intAry 000 초기값이 0, strAry null null null 초기값이 null 그래서 null인지 아닌지 확인
	
	public static void main(String[] args) { // split:문자를 분리 ,를 기준으로 여러개를 분리하겠다. String[]문자열을 받는 배열
		String[] infoAry = "홍길동, 80,".split(","); // 80은 문자 
		System.out.println(infoAry[0]);
		System.out.println(infoAry[1]);
		System.out.println(Integer.parseInt("80") * Integer.parseInt("70")); // 점수는 문자

		Scanner scn = new Scanner(System.in);		

		String[] studentAry = new String[3];
		boolean run = true;	
		
		while(run) {
			
			System.out.println("1.학생이름,점수 2.최고점수 9.종료"); //1.입력 2.출력 할것
			System.out.print("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine()); // 그 값을 menu에 담겠다. 구분하려고 switch
			
			switch(menu) {
			case 1: // 학생이름,점수입력.
				for(int i = 0; i < studentAry.length; i++) {
					System.out.print("학생의 이름, 점수 값을 입력하세요>");
					studentAry[i] = scn.nextLine();
				}
				System.out.println("등록완료!");
				break;
			case 2: //학생이름, 점수, 최고점수 출력.
				int max = 0;
				for(int i = 0; i < studentAry.length; i++) {
					int temp = Integer.parseInt(studentAry[i].split(",")[1]);
					if(max <temp) {
						max = temp;
					}
				}
				System.out.printf("최고점수는 %d\n", max);
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false; //반복문 종료?
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
			
		} // end of while.
		
		System.out.println("end of prog.");
		
	} // end of main.
	
} // end of class.

