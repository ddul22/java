package com.yedam;

import java.util.List;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

public class Test {
	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		List<Student> result = sdao.studentList();
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println("힉번: " + result.get(i).getStudentNo());
			
		}
	}
}
