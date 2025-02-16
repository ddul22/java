package com.yedam.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * 실행클래스.
 */
public class EmpApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();

		boolean run = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 사번, 이름, 전화번호, 입사일, 급여 등록
				System.out.print("사번입력>> ");
				String empNo = scn.nextLine();
				System.out.print("이름입력>> ");
				String eName = scn.nextLine();
				System.out.print("전화번호입력>> ");
				String tel = scn.nextLine();
				System.out.print("입사일입력>> ");
				String hdate = scn.nextLine();
				System.out.print("급여입력>> ");
				int salary = Integer.parseInt(scn.nextLine());
				Date hhdate = null;
				try {
					hhdate = sdf.parse(hdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (dao.registerEmp(new Employee(empNo, eName, tel, hhdate, salary))) {
					System.out.println("등록성공");
				}
				break;
			case 2: // 목록
				List<Employee> result = dao.search();
				System.out.println("사번   이름   전화번호");
				for(Employee results:result) { //3.?results:result 뭘까? 
					System.out.println(results.getEmpNo() + " " + results.getEmpName() + " " + results.getTelNo());
				}
				break;
			case 3: // 수정
				System.out.printf("사번 급여>> ");
				String param = scn.nextLine();
				if(dao.modifyEmp(param)) {
					System.out.println("수정완료");
				}else{
					System.out.println("수정실패");
				};
				break;//
			case 4: // 삭제
				System.out.print("사번>> ");
				String remove = scn.nextLine();
				if(dao.removeEmp(remove)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 5: // 조회
				System.out.print("입사일자>> ");
				String hiredate = scn.nextLine();
			
				
				}
				break;

			}

		}
	}


