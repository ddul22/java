package com.yedam.interfaces.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yedam.reference.Board;

/*
 * 배열활용.
 */
public class EmpAryExe implements EmpDAO {

	
	Employee[] employees = new Employee[10]; // 저장
	
	public EmpAryExe() {
		employees[0] = new Employee(2,"홍길동","432-1234");
		employees[1] = new Employee(8,"박길동","436-1234");
		employees[2] = new Employee(9,"김사원","439-1234");		
	}
	
	@Override
	public boolean registerEmp(Employee emp) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				employees[i] = emp;
				System.out.println("등록완료");
				break; // 정상등록.
			}
		}
		return false; // 등록실패.
	}

	@Override
	public boolean modifyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < employees.length; i++) {
			// 사원번호 비교.
			if (employees[i] != null && employees[i].getEmpNo() == emp.getEmpNo()) {
				// 연락처값이 ""이 아닐때 변경.
				if(!emp.getTelNo().equals("")) {
					employees[i].setTelNo(emp.getTelNo());
				}
				try {
					// 값을 변경안하려고 엔터("")일 경우 1900-01-01
					if(!emp.getHireDate().equals(sdf.parse("1900-01-01"))){
						employees[i].setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// 급여변경을 안하려고 엔터만 입력했을때는 변경안함.
				
				if(emp.getSalary()!=0) {
					employees[i].setSalary(emp.getSalary());					
				}
				return true; // 정상수정.
			}
		}
		return false; // 수정을 못함.
	}

	@Override
	public boolean removeEmp(int empNo) {
		for(int i = 0; i < employees.length; i++) {
			if(employees[i].getEmpNo() == empNo) {
				employees[i] = null; // 삭제.
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee[] search(Employee emp) {
		Employee[] result = new Employee[10];
		int idx = 0;
		String name = emp.getEmpName();
		
		for(int i = 0; i < employees.length; i++) {
			// indexOf 사용.
			if(employees[i] != null && employees[i].getEmpName().indexOf(name) > -1) {
				result[idx] = employees[i];
				idx++;
			}
		}
		return result;
	}
	
}
