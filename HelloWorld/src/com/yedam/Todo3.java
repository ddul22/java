package com.yedam;

import java.util.Scanner;

public class Todo3 {
	public static void main(String[] args) {

		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String[][] friendAry = new String[100][3];
		friendAry[0] =new String[] {"홍길동1","1111-2222","남"};
		friendAry[1] =new String[] {"홍길동2","1111-2222","여"};
		friendAry[2] =new String[] {"홍길동3","1111-2222","남"};
		while (run) {
			System.out.println("1.목록(이름,연락처,성별) 2.등록 3.조회(성별) 9.종료");
			System.out.print("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 이름,연락처,성별 전체 조회
				for(int i = 0; i <friendAry.length; i++) {
					if(friendAry[i][0] != null) {
						String name = friendAry[i][0];
						String phone = friendAry[i][1];
						String gender = friendAry[i][2];
						System.out.printf("이름: %s 연락처: %s 성별: %s \n", name, phone, gender);
					}
				}
				break;
			case 2:
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i][0] == null) {
						System.out.println("이름을 입력>>");
						String name = scn.nextLine();
						if(name.equals("stop")) {
							break;
						}
						System.out.println("연락처를 입력>>");
						String phone = scn.nextLine();
						System.out.println("성별을 입력>>");
						String gender = scn.nextLine();
						friendAry[i][0] = name;
						friendAry[i][1] = phone;
						friendAry[i][2] = gender;
					}
				}

				break;

			case 3:
				System.out.print("조회할 성별을 입력하세요");
				String gender = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if(friendAry[i][1] != null) {
						
						String findgender = friendAry[i][2];
						if (gender .equals(findgender)) {
							String name = friendAry[i][0];
							String phone = friendAry[i][1];
							System.out.printf("이름: %s 연락처: %s 성별:%s 입니다 \n", name, phone, findgender);
						}
					}
				}
				break;
			case 4:
				System.out.print("삭제할 이름을 입력하세요");
				String rmname = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
						if(friendAry[i][0] != null) {
							String removename = friendAry[i][0];
							if(rmname .equals(removename)) {
								 
							}//
					}

				}
				break;
			case 5:
				System.out.print("수정할 이름과 연락처를 입력하세요");
				String renew = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {

				}
				break;
			case 9:
			}

			System.out.println("end of prog.");
		} // end of while.
	}
} // end of class.
