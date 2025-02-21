package com.yedam.reference;

public class StaticExe {
	public static void main(String[] args) {
		// m1, m2 참조변수.
		MemberExe m1 = MemberExe.getInstance();
		MemberExe m2 = MemberExe.getInstance();
		
		System.out.println(m1 == m2);
	}
}
