package com.yedam.api;

public class MemberExe {
	public static void main(String[] args) {
		// equals (객체비교)
		Object o1 = new Object();
		Object o2 = new Object();
		
		// 비교연산자 : 참조값 비교.
		System.out.println(o1 == o2);
		// 논리값 비교.
		System.out.println(o1.equals(o2));
		
		Member m1 = new Member();
		m1.memberId = "user01";
		m1.memPoint = 90;
		Member m2 = new Member();
		m2.memberId = "user01";
		m2.memPoint = 95;
		
		System.out.println(m1.equals(m2));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1.equals(s2));
	}
}
