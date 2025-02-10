package com.yedam.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 사원번호(23-11, 23-12, 23-13)
 * 사원이름(홍길동, 김길동, 박길동)
 * 입사일자(2023-10-01)
 * 급여(300)
 */
public class Employee { //2.?왜 클래스를 사용?
	private String empNo;
	private String empName;
	private String telNo;
	private Date hireDate;
	private int salary;
	
	public Employee() {
		
	}
	

	
	public Employee(String empNo, String empName, String telNo, Date hireDate, int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.telNo = telNo;
		this.hireDate = hireDate;
		this.salary = salary;
	}



	public String getEmpNo() {
		return empNo;
	}



	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getTelNo() {
		return telNo;
	}



	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}



	public Date getHireDate() {
		return hireDate;
	}



	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
