package com.yedam.reference;

public class Calculator {
	
	//곱 메서드
	public int[] gob(int gobhagi) {
		int [] gobAry = new int[9];
		for(int i = 1; i <= gobAry.length; i++) {
			gobAry[i-1]= gobhagi *i;
		}
		return gobAry;
	}
	// 1월달 출력.
	public void showcalendar() {
		String[] days = {"Sun", "Mon", "Tue", "Thr", "Sat"};
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println("\n---------------------");
		// 공백, 말일 계산.
		
		
		
	}
	
	public Book getBookInfo(String btitle, Book[] bookAry) {
		Book[] bookRepo = {new Book("이것이 자바다", "신용권", "한빛미디어", 10000),
				          new Book("자바스크립트기초", "김자바", "자바출판사", 15000),
				          new Book("혼자공부하는자바", "혼공자", "한빛미디어", 20000)};
	//배열검색.
	for(int i = 0; i < bookAry.length; i ++) {
		if(bookAry[i].getBookName().equals(btitle)) {
			return bookAry[i];
		}
	}
		return null;
	}
	// 1 ~ 100 사이의 임의값을 n개 반환.
	public int[] randomAry(int n) {
		int[] result = new int[n];
		for(int i = 0; i < result.length; i++) {
			result[i] = (int)(Math.random()*100) + 1;
		}
		return result;
	}

	// 두 숫자중에서 큰 값을 반환.
	public int getMax(int num1, int num2) {
		return num1 > num2 ? num1 : num2;

	
//		if(num1>num2) {
//			return num1;
//		} 
//		else {
//		return num2;
//	}
	}
	// 183페이지 5번문제
	// *
	// **
	// ***
	// ****
	public void printStar(int times) {
		for (int i = 1; i <= times; i++) {
			printStar(i, "*");
			System.out.println();
		}
	}

	// 별 출력하는 메소드.
	public void printStar(int times, String types) { // 매개변수.
		for (int i = 1; i <= times; i++) {
			System.out.print(types);
		}
	}

	// 두수의 합을 반환.
	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	// 동일한 메소드명을 중복정의: overloading.
	public double sum(double num1, double num2) {
		return num1 + num2;
	}

	public int sum(int[] intAry) {
		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			sum += intAry[i];
		}
		return sum;
	}
}