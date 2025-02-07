package com.yedam.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 학생정보 관리프로그램 v.1
 * 학생이름, 키, 몸무게, 점수. 
 */
public class StudentApp {
	Scanner scn = new Scanner(System.in);
	boolean run = true;

	// 임시저장.
	List<Student> Students = new ArrayList<>();

	public StudentApp() {
		init(); // 초기갑.
	}
	public void start() {
		while (run) {

			System.out.println("1.목록 2.추가 3.삭제 9.종료");
			System.out.println("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				studentsList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				removeStudnet();
				break;
			case 9:
				save();
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");

		System.out.println("end of prog.");
	}// end of start.

	public void studentsList() {

		// 이름 점수
		// ---------
		// 홍길동 90

		System.out.println(" 이름    점수");
		System.out.println("-----------");
		for (Student std : Students) {
			System.out.println(" " + std.getName() + "  " + std.getScore() + "");
		}
	} // end of StudentList().

	public void addStudent() {
		System.out.print("학생이름 입력>> ");
		String name = scn.nextLine();
		System.out.print("학생키 입력>> ");
		double height = Double.parseDouble(scn.nextLine());
		System.out.print("학생몸무게 입력>> ");
		double weight = Double.parseDouble(scn.nextLine());
		System.out.print("학생점수 입력>> ");
		int score = Integer.parseInt(scn.nextLine());

		Students.add(new Student(name, height, weight, score)); // 추가.
		System.out.println("등록완료.");

	} // end of StudentList().

	public void removeStudnet() {
		System.out.print("학생이름 입력>> ");
		String name = scn.nextLine();

		// 삭제.
		for (int i = 0; i < Students.size(); i++) {
			if (Students.get(i).getName().equals(name)) {
				Students.remove(i);
				System.out.println("삭제완료.");
				return;

			}
		}
	} // end of StudentList().

	public void save() {
		// c:/temp/students.txt
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			// 갯수만큼 반복저장.
			for (Student std : Students) {
				writer.write(
						std.getName() + " " + std.getHeight() + " " + std.getWeight() + " " + std.getScore() + "\n");
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("saved.");
	} // end of save().
	
	// 파일 읽어서 컬렉션저장.
	public void init() {
		// c:/temp/students.txt
		try {
			Reader reader = new FileReader("c:/temp/studentList.txt");
			BufferedReader br = new BufferedReader(reader);

			while (true) {
				String str = br.readLine();
				if (str == null)
					break; // 반복종료.
				String[] ary = str.split(" "); // {이름, 키, 몸무게, 점수}
				Student student = new Student(ary[0], Double.parseDouble(ary[1]), Double.parseDouble(ary[2]),
						Integer.parseInt(ary[3]));

				Students.add(student); // 컬렉션 추가.
			}
			br.close();
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
