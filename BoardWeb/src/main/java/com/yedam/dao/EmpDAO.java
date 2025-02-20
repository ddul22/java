package com.yedam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Employee;

//connection객체 StudentDAO 도 필요해서 잘라내기해서 넣음. DAO클래스를 상속받아서
public class EmpDAO extends DAO {

	
	// 상세조회.
	public Employee selectEmp(int empNo) {
		String query = "select * from tbl_employees "
				+ "where emp_no = ?";
		try {
//			Statement stmt = getConnect().prepareStatement(query); // 에러나서 DAO 상속받음. 위에 extends DAO. PreparedStatement이렇게 해도 되고
			psmt.setInt(1, empNo);
			ResultSet rs = stmt.executeQuery(query); // 조회.
			if(rs.next()) { // 조회결과가 한건 있으면...
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no")); // 칼럼값.
				emp.setEmpName(rs.getString("emp_name"));
				emp.setTelNo(rs.getString("tel_no"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				
				return emp; // 반환.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회된 결과 없음(null)
	}
	
	// 등록.
	public boolean registerEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "insert into tbl_employees ";
		query += "values ("+emp.getEmpNo()+", '"+emp.getEmpName()+"', '"+emp.getTelNo()+"', '"+sdf.format(emp.getHireDate())+"', "+emp.getSalary()+")";
		
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(query);
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return false;
	} // end of resisterEmp().
	
	// 목록.
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		String qry = "select *  "+ "from tbl_employees "
//			    + "where emp_name = nvl('" + emp.getEmpNo() + '", emp_name) " 
				+ "where emp_name = nvl(?, emp_name)" // number, varchar2 에 따라 처리.
                + "order by emp_no";
		System.out.println(qry);
		try {
//			Statement stmt = getConnect().createStatement();
			PreparedStatement stmt = getConnect().prepareStatement(qry);
			stmt.setString(1, emp.getEmpName()); // 첫번째 ?에 사원이름을 대입.
			ResultSet rs = stmt.executeQuery();
			// 조회결과.
			while(rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmpNo(rs.getInt("emp_no"));
				emp1.setEmpName(rs.getString("emp_name"));
				emp1.setHireDate(rs.getDate("hire_date"));
				emp1.setSalary(rs.getInt("salary"));
				emp1.setTelNo(rs.getString("tel_no"));
				
				empList.add(emp1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
