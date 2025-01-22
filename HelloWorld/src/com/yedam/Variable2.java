package com.yedam;

public class Variable2 {

	public static void main(String[] args) {

		for (int j = 2; j <= 6; j++) {

			int num = j;
			for (int i = 1; i <= 9; i++) {
//			System.out.print(num + " * " + i + " = " + num * i + "\n");  //\n 줄바꿈 
				System.out.printf(" %d * %d = %2d ", num,i , num * i); // `${num} * ${i} = `${num}`랑 같다. %1$d에서 %다음 숫자는
																		// 순번을 정하는 거 %2d에서 2는 공백설정.
			}
			System.out.println();
		}
		System.out.println("end of prog");
	}

}
//옆으로 쭉 나오도록 바꾸기
