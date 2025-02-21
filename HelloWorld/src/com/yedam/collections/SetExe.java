package com.yedam.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("홍길동");
		set.add("반값습니다.");
		set.add("1000"); // set은 int못담음 문자열만 가능
		set.add(String.valueOf(true));
		set.add("홍길동");
		
		Iterator<String> iter = set.iterator(); // 반복자. for문 사용x
		while(iter.hasNext()) { // 컬렉션에 요소있는지 확인. 있으면 true반환
			String result = iter.next(); // 컬렉션의 요소를 반환.
			System.out.println(result); // 중복된 객체는 반복x 
		}
		
		for(String str : set) { // 반복자대신 향상된 for구문도 사용가능.
			System.out.println(str);
		}
	}
}
