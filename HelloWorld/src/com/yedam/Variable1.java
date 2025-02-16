package com.yedam;

public class Variable1 {
	
	public static void main(String[] args) {
		// int(4byte)
		int num1 = 1101111;
		
		byte num2 = 27; // byte(1byte)
		short num3 = 128; // short(2byte)
		long num4 = 9223372036854775807L;
		System.out.println(Long.MAX_VALUE);
		
		byte num5 = 20;
		int result = (byte) (num2 + num5); // 강제형변환(casting)
		int intResult = num1 + num5; // 자동형변환(promotion)
		System.out.println(intResult);
		
		// 데이터타입 변수이름 = 값
		int[] intAry = {10, 25, 82, 11}; // 기억할것
		String[] strAry = {"Hong", "Park", "Choid"};
		strAry[2] = "Kim";
		
		int[] anotherAry = new int[10]; // 크기 10을 생성. 기억할것
		for(int i = 0; i < anotherAry.length; i++) {
			anotherAry[i] = (int) (Math.random() * 100); // 34.56546453 강제형변환 
		}
		// 배열값을 출력.
		for(int num : anotherAry) {
			System.out.println(num);
		}
		System.out.println(anotherAry);
		
		int sum = 0;
		for(int i = 0; i < intAry.length; i++) { // i=0인 이유는 인덱스 생각해서 첫번째 인덱스는 0번째이니까
			sum += intAry[i];
		}
		System.out.println("길이"+intAry.length);
		System.out.println(sum);
	}
}
