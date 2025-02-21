package com.yedam.interfaces.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * EmpDAO(인터페이스) 구현하는 클래스.
 */
public class EmpDBExe implements EmpDAO {

	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클DB의 접속정보.
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		try {
			conn = //
			 DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public boolean registerEmp(Employee emp) {
		String query = "insert into tbl_employees ";
		query += "values ("+emp.getEmpNo()+", "+emp.getEmpName()+", "+emp.getTelNo()+", "+emp.getHireDate()+", "+emp.getSalary()+")";
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

	@Override
	public boolean modifyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "update tbl_employees \r\n"
				+ "set tel_no = nvl('" + emp.getTelNo() + "', tel_no), \r\n"
				+ "    hire_date = case to_date('" + sdf.format(emp.getHireDate())+"', 'yyyy-mm-dd') \r\n"
				+ "                when to_date('1900-01-01', 'yyyy-mm-dd') then hire_date \r\n"
				+ "                else to_date('"+sdf.format(emp.getHireDate()) + "', 'yyyy-mm-dd') \r\n"
				+ "                end, \r\n"
				+ "    salary = case " + emp.getSalary() + " when 0 then salary \r\n"
				+ "                                          else "+emp.getSalary()+"\r\n"
				+ "             end \r\n"
				+ "where emp_no = " + emp.getEmpNo();
		
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(sql); // 처리된 건수.
			if(r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 수정변경값 없음. 
	}

	@Override
	public boolean removeEmp(int empNo) {
		String sql = "delete from tbl_employees where emp_no = " +empNo;
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(sql); // 처리된 건수.
			if(r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;  
	}

	@Override
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		String qry = "select *  "+ 
					  "from tbl_employees " + 
					  "where emp_name = nvl('" +emp.getEmpName() + "', emp_name) " +
					 " order by emp_no";
		try {
			Statement stmt = getConnect().createStatement();
			ResultSet rs = stmt.executeQuery(qry);
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
