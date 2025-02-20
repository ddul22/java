package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {
	
	public boolean addStudent(Student student) {
		String sql = "insert into tbl_student (student_no, student_name, phone, address) "
				+ "values(?, ?, ?, ?)"; // 실행하는 쿼리 만들기
		
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, student.getStudentNo()); // 1:첫번째 물음표(학생번호)
			psmt.setString(2, student.getStudentName());
			psmt.setString(3, student.getPhone());
			psmt.setString(4, student.getAddress());
			
			// 쿼리실행 할때. executeUpdate();사용
			int r = psmt.executeUpdate(); // 처리된 건수반환.
			if(r>0) {
				return true;// 등록성공.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패.
	}
	
	
	// 학생목록을 반환 메소드. 참고) EmpDAO.search()
	public List<Student> studentList(){
		List<Student> stdList = new ArrayList<>();
		String qry = "select * "+ "from tbl_Student ";
	            //+ "where std_name = nvl(?, std_name)";
		try {
			psmt = getConnect().prepareStatement(qry);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student std1 = new Student();
				std1.setStudentNo(rs.getString("Student_No"));
				std1.setStudentName(rs.getString("Student_Name"));
				std1.setPhone(rs.getString("Phone"));
				std1.setAddress(rs.getString("Address"));
				stdList.add(std1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stdList;
	} // end of studentList()
	
}
