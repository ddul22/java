package com.yedam; 

public class Variable2copy { // 6단까지 옆으로 쭉 나오게 하기
	
	public static void main (String[] args) {
	
		for (int j = 1; j <= 6; j++) {
			
			int num = j;
			for(int i = 1; i <= 9; i++) {
				
				System.out.printf(" %d * %d = %2d ", i, num, num * i);
			}
			System.out.println();
		}
		System.out.println("end of prog");
	}















}


