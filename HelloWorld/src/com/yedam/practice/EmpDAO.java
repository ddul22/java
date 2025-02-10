package com.yedam.practice;

import java.util.ArrayList;
import java.util.List;

/*
 * 저장공간(List<Employee> storage)
 */
public class EmpDAO {

	List<Employee> empList = new ArrayList<>(); //1.?왜 비어있어??
	
	public boolean registerEmp(Employee emp) {
		empList.add(emp);
		return true; // 3.?어떨땐 true?? 
	}
	
	public boolean modifyEmp(String emp) {
		String empNo = emp.split(" ")[0];
		int salary = Integer.parseInt(emp.split(" ")[1]);
		return false; // 4.?어떨땐 false??
		
	}
	
	public boolean removeEmp(int empNo) {
		return false;
	}
	
	public List<Employee> search() { 
		
		return empList;
	}
}
