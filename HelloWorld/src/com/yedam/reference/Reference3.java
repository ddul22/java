package com.yedam.reference;

import java.util.Scanner;

public class Reference3 {
	public static void main(String[] args) {
		exe();
	} // end of main.
	
	public static void exe() {
		Scanner scn = new Scanner(System.in);
		// 이름, 연락처, 성별 => 100개 공간.
		String[][] friends = new String[100][3];  // 한번에 담는거 -> 배열 더 담아야 100개를 3개에 담는다
		friends[0][0] = "홍길동";  //첫번째 위치
		friends[0][1] = "010-1111-2222";
		friends[0][2] = "남";
		friends[1] = new String[] {"김민수", "010-1212-2323", "남"}; //
	
		System.out.println("이름을 입력>>");
		String name = scn.nextLine(); 
		System.out.println("연락처를 입력>>");
		String phone = scn.nextLine(); 
		System.out.println("성별을 입력>>");
		String gender = scn.nextLine(); 
		
		friends[2][0] = name;
		friends[2][1] = phone;
		friends[2][2] = gender;
		friends[2] = new String[] { "1", "2", "3"};
		
//		friends[5] ={null, null, null};
		
		for (int i = 0; i <friends.length; i++) {
			if (friends[i] != null && friends[i][0] != null) {
				System.out.printf("이름은 %s, 연락처는 %s\n", friends[i][0], friends[i][1]);
			}
		}
		
	}
}
