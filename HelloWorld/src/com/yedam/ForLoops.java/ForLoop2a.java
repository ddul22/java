package com.yedam;

import java.util.Scanner;

public class ForLoop2a {
	
	public static void main(String[] args) { // split:문자를 분리 ,를 기준으로 여러개를 분리하겠다. String[]문자열을 받는 배열
//		String[] infoAry = "홍길동, 80".split(","); // 80은 문자 
//		System.out.println(infoAry[0]); 
//		System.out.println(Integer.parseInt("80") * Integer.parseInt("70")); // 점수는 문자
		Scanner scn = new Scanner(System.in);		
		System.out.println("이름, 점수 값을 입력");
		String userVal = scn.nextLine();
		String[] users = userVal.split(",");

		System.out.printf("이름은 %s이고 점수는 %s점 입니다",users[0],users[1]);		
		
//		String[] studentAry = new String[3];
//		boolean run = true;	
	} // end of main.
	
} // end of class.

