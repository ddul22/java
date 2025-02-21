package com.yedam.reference;

public class ReferenceExe1 {

	public static void main(String[] args) { // 매개값으로는 문자열 String[] args
		// 배열선언. int, double(소수점, 키나 몸무게)
		double[] dblAry = new double[5]; // double타입 배열 선언 값이 null -> 배열공간 만드는게 new. 초기값0
		dblAry[0] = 171.3; // 위에서 만들어진 배열에 첫번째 값을 담겠다. 변수이름만 같고 다른 배열
		System.out.println(dblAry.length);
		for (int i = 0; i < dblAry.length; i++) { // 배열크기(dblAry.length)가 5라서 5번 반복

		}

		dblAry = new double[] { 160.5, 174.6 }; // 다시선언해서 배열 담겠다. 이름만 같음 위와 다른 배열
		System.out.println(dblAry.length);

		// 배열[][] => 다차원배열. // 특정위치에 갔는데 또 배열이 있네 어제는 문자열이 담겨있는데 지금은 정수가 아니라 배열
		int[][] intAry = new int[2][3]; // 2와 3은 크기. 2행 3열 가지는 다차원 배열 2 * 3 배열 선언.여기서는 인덱스값?
		intAry[0][0] = 10; // 0번째 위치에 값은 10이라는 값을 담겠다.
		intAry[0][1] = 20;
		intAry[0][2] = 30;
		intAry[1][0] = 20;
		intAry[1][1] = 30;
		intAry[1][2] = 40;
		for (int j = 0; j < intAry.length; j++) {
			for (int i = 0; i < intAry[0].length; i++) {
				System.out.println("[" + j + "][" + i + "] => "+intAry[0][i]); // 
			}
		}
	}

	public int sum(int num1, int num2) { // 첫번째 매개값 두번째 매개값 반환값 다 int타입
		return num1 + num2; // num1 num2 더한 값 반환하겠다
	}

	public void method1() { // return값 없으면 void 적어주기
		System.out.println("method1()이 호출되었습니다");

	}

	private void method2() {
		System.out.println("method2()이 호출되었습니다");
	}
}
