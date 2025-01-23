package com.yedam;

import java.util.Scanner;

public class ForLoop2b {  // intAry 000 초기값이 0, strAry null null null 초기값이 null 그래서 null인지 아닌지 확인
	
	public static void main(String[] args) { // split:문자를 분리 ,를 기준으로 여러개를 분리하겠다. String[]문자열을 받는 배열
//		String[] infoAry = "홍길동, 80".split(","); // 80은 문자 
//		System.out.println(infoAry[0]); 
//		System.out.println(Integer.parseInt("80") * Integer.parseInt("70")); // 점수는 문자

		Scanner scn = new Scanner(System.in);		

		String[] studentAry = new String[3];
		boolean run = true;	
		
		for (int i = 0; i < studentAry.length; i++) {
			System.out.println(studentAry[i]); // "null" != null. 얘는 null이라는 값으로 초기화 하겠다.
		}
	} // end of main.
	
} // end of class.

