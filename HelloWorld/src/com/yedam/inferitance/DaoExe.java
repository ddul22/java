package com.yedam.inferitance;

import java.util.Scanner;

/*
 * 실행클래스(main)
 * mysql
 * oracle
 */
public class DaoExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
//		MysqlDao dao = new MysqlDao();
		OracleDao dao = new OracleDao();
		
		while(run) {
			System.out.println("1.등록 2.삭제 3.조회 4.종료" );
			System.out.println("선택>>");
			int menu = scn.nextInt();
			
			switch(menu) {
			case 1: // 등록.
				dao.register();
			case 2: // 삭제.
				dao.remove();
			case 3: // 조회.
				dao.search();
			case 9:
				run = false;
			}
		}
	}
}
