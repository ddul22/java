package com.yedam.inferitance;

public class CastingExe {
	public static void main(String[] args) {
		// byte < short < int < long
		int n1 = 100;
		long n2 = 0;
		n1 = (int) n2; // casting
		n2 = n1; // promotion
		
		Friend f1 = new ComFriend("","","",""); // promotion.
//		ComFriend f2 = (ComFriend) new Friend("", ""); // casting.
		f1 = new Friend("","");
		if(f1 instanceof ComFriend) {//
			ComFriend f2 = (ComFriend) f1;
			System.out.println(f2.showInfo());
		} else {
			System.out.println("형변환 못함.");
		}
	}
}
