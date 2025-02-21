package com.yedam.reference;

import java.util.Scanner;
/*
 * 
 */
public class StudentExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Student[] students = new Student[5];

		Student std1 = new Student(); // 인스턴스 생성.
		std1.studentName = "홍길동";
		std1.engScore = 80;
		std1.mathScore = 85;
		std1.gender = Gender.MEN;

		Student std2 = new Student();
		std2.studentName = "김민수";
		std2.engScore = 88;
		std2.mathScore = 80;
		std2.gender = Gender.MEN;
		
		// 홍정학, 75, 90
		Student std3 = new Student();
		std3.studentName = "홍정학";
		std3.engScore = 75;
		std3.mathScore = 90;
		std3.gender = Gender.WOMEN;

		students[0] = std1;
		students[1] = std2;
		students[2] = std3;
		students[3] = new Student("김민지", 88, 92);

		// 학생의 이름을 입력받는 변수: studName
		// 학생의 평균을 출력하는 프로그램을 작성.
		System.out.println("평균점수를 확인할 학생의 이름을 입력하세요");
		String studName = scn.nextLine();
		for (int i = 0; i < students.length; i++) {
//			if (students[i] != null && students[i].getAverage() >= 85) {
//				students[i].printInfo();
//			}
			if(students[i] != null && students[i].studentName.equals(studName)) {
				System.out.printf("%s의 점수는 %.2f입니다", studName, students[i].getAverage());
				
			}
			 
		}

	}
}
