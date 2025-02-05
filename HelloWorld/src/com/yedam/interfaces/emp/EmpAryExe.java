package com.yedam.interfaces.emp;
/*
 * 배열활용.
 */
public class EmpAryExe implements EmpDAO {

	
	Employee[] employees = new Employee[10]; // 저장

	@Override
	public boolean registerEmp(Employee emp) {
		return false;
	}

	@Override
	public boolean modifyEmp(Employee emp) {
		return false;
	}

	@Override
	public boolean removeEmp(int empNo) {
		return false;
	}

	@Override
	public Employee[] search(Employee emp) {
		return null;
	}
	
}
