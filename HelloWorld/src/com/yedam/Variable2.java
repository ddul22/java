package com.yedam;

public class Variable2 {

	public static void main(String[] args) {

		for (int j = 1; j <= 9; j++) {

			int num = j;
			for (int i = 2; i <= 6; i++) {
//			System.out.print(num + " * " + i + " = " + num * i + "\n");  //\n 줄바꿈 
				System.out.printf(" %d * %d = %2d ", i, num, num * i); // `${num} * ${i} = `${num}`랑 같다. %1$d에서 %다음 숫자는
																		// 순번을 정하는 거
			}
			System.out.println();
		}
		System.out.println("end of prog");
	}

}
//옆으로 쭉 나오도록 바꾸기