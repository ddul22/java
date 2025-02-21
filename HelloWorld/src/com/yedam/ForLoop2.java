package com.yedam;

import java.util.Scanner;

public class ForLoop2 { // intAry 000 초기값이 0, strAry null null null 초기값이 null 그래서 null인지 아닌지 확인

	public static void main(String[] args) { // split:문자를 분리 ,를 기준으로 여러개를 분리하겠다. String[]문자열을 받는 배열
//		String[] infoAry = "홍길동, 80,85".split(","); // 80은 문자 
//		System.out.println(infoAry[0]);
//		System.out.println(infoAry[1]);
//		System.out.println(infoAry[2]);
//		System.out.println(Integer.parseInt("80") * Integer.parseInt("70")); // 점수는 문자

//		String[] strAry = new String[10];
//		strAry[0] = "홍길동"; 
//		String name = "김길동";
//		for(int i = 0; i < strAry.length; i++) {
//			if(strAry[i] == null) {  // 빈공간에 등록 후 반복문 종료.
//			   strAry[i] = name; 
//			   break; // 1건만 입력하고 멈추겠다. 안그러면 다 김길동으로 채울테니까
//			}
//		}
//		
//		for(int i = 0; i < strAry.length; i++) {
//			if(strAry[i] != null) {            
//			   System.out.println(strAry[i]);
//			}
//		}

		Scanner scn = new Scanner(System.in);
//		String searchName = scn.nextLine();
//		System.out.println("박우식".equals(searchName)); // .equals 문자열에만 쓸 수 있는 문자열 비교하는 메소드 "박우식 == searchName 이렇게 하면 안됨

		String[] studentAry = new String[100];
		studentAry[0] = "홍길동,80";
		studentAry[1] = "김민수,70";
		studentAry[2] = "박우식,85";

		boolean run = true;

		while (run) {

			System.out.println("1.학생이름,점수 2.최고점수 3.학생입력(한건씩) 4.정수조회(이름) 9.종료"); // 1.입력 2.출력 할것
			System.out.print("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine()); // 그 값을 menu에 담겠다. 구분하려고 switch

			switch (menu) {
			case 1: // 학생이름,점수입력.
				for (int i = 0; i < studentAry.length; i++) {
					System.out.print("학생의 이름, 점수 값을 입력하세요>");
					studentAry[i] = scn.nextLine();
				}
				System.out.println("등록완료!");
				break;
			case 2: // 학생이름, 점수, 최고점수 출력.
				int max = 0;
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) { // 값이 있을 경우.
						int temp = Integer.parseInt(studentAry[i].split(",")[1]);
						if (max < temp) {
							max = temp;
						}
					}
				}
				System.out.printf("최고점수는 %d\n", max);
				break;
			case 3: // 메뉴를 선택할 때마다 한 건씩 입력하겠다
				String value = scn.nextLine();
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] == null) {
						studentAry[i] = value;
						break;
					}
				}
				System.out.println("한건에 대해 등록되었습니다.");
				break;

			case 4: //  학생이름을 넣어서 점수를 조회
				System.out.print("찾으실 이름을 입력해주세요.");      
				String searchName = scn.nextLine();
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) {
						String findName =	studentAry[i].split(",")[0];  
						if (searchName.equals(findName)) {
							String score =studentAry[i].split(",")[1];
							System.out.printf("%s의 점수는 %s점입니다 \n",findName,score);
						}
					}
				}
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false; // 반복문 종료?
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}

		} // end of while.

		System.out.println("end of prog.");

	} // end of main.

} // end of class.
