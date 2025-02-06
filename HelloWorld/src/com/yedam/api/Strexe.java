package com.yedam.api;

public class Strexe {
	public static void main(String[] args) {

		String tel1 = " 02";
		String tel2 = "1 2 3   ";
		String tel3 = "    1234   ";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
	}
}