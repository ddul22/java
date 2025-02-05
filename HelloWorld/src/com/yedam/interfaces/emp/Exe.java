package com.yedam.interfaces.emp;

import java.util.ArrayList; // ArrayList 클래스 
import java.util.List; // List 인터페이스

import com.yedam.inferitance.ComFriend;
import com.yedam.inferitance.Friend;
import com.yedam.reference.Student;

/*
 * String[] strAry;
 * Collection 1) List 2) Set 3) Map 
 */
public class Exe {
	public static void main(String[] args) {	
		System.out.println("홍길동".indexOf("길도")); // -1보다 큰 값 반환.
		
		
		
		
		// 학생정보를 저장하는 컬렉션(ArrayList) 선언.
		// 3명 추가.
		
		List<String> strList = new ArrayList<String>();
		List<Student> student = new ArrayList<Student>();
		
		student.add(new Student("홍길동",75,90));
		student.add(new Student("김민수",85,80));
		student.add(new Student("박성용",95,60));
		System.out.println();
		
		// 삭제.
		for(int i = 0; i < student.size(); i++) {
			if(student.get(i).getStudentName().equals("박길동")) {
				// students[i]
				student.remove(i);
				break;
			}
		}
		// 반복문 활용 출력. 이름만 출력
		for(int i = 0; i < student.size(); i++) {
			System.out.println("이름: " + student.get(i).getStudentName());
		}
	}
	void method() {
		String[] strAry = new String[10]; // 배열.
		List<String> strList = new ArrayList<String>(); // 컬렉션.
		List<Friend> friends = new ArrayList<Friend>(); // 
		
		friends.add(new Friend("홍길동", "010-111"));
		friends.add(new ComFriend("김길동","010-2222","국민은행","신용보증팀"));
		
		friends.remove(new Friend("홍길동","010-111"));
		System.out.println("friends크기: " + friends.size());
		
		System.out.println(friends.get(1).getFriendName());
		
		// 추가.
		strList.add("안녕하세요");
		strList.add("Hello");
		strList.add("반갑습니다");
		System.out.println("strList크기: " + strList.size());
		
		// 삭제.
		strList.remove(0);
		strList.remove("Hello"); 
		System.out.println("strList크기: " + strList.size());
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
	}
}
