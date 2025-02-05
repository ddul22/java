package com.yedam.interfaces.emp;
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
