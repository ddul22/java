package com.yedam;

import java.util.Scanner;

/*
 * 친구정보관리 앱 v.1
 * 이름,연락처,성별(남/여) => 홍길동,010-1234-2345,남
 * 1.목록 (이름,연락처,성별) 2.등록 3.조회(성별) 4.삭제(이름) 5.수정(이름)연락처를 수정 9.종료
 * String[] friendAry 크기는 100개 ; forloop1 forloop2 참고하고 while 등등 반복문 사용
 */
public class Todo2 {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[100];

		while (run) {
			System.out.println("1.목록(이름,연락처,성별) 2.등록 3.조회(성별) 4.삭제(이름) 5.수정(이름)연락처를 수정 9.종료");
			System.out.print("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 이름,연락처,성별 전체 조회
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						String name = friendAry[i].split(",")[0];
						String tel = friendAry[i].split(",")[1];
						String gender = friendAry[i].split(",")[2];
						System.out.printf("이름: %s 전화번호:%s 성별:%s \n", name, tel, gender);

					}
				}
				break;
			case 2:
				for (int i = 0; i < friendAry.length; i++) {
					System.out.print("이름,연락처,성별을 입력하세요");
					String add = scn.nextLine();
					if (add.equals("stop")) {
						break;
					}
					friendAry[i] = add;

				}
				System.out.println("등록완료!");
				break;

			case 3:
				System.out.print("조회할 성별을 입력하세요");
				String gender = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {

						String findgender = friendAry[i].split(",")[2];
						if (gender.equals(findgender)) {
							String name = friendAry[i].split(",")[0];
							String tel = friendAry[i].split(",")[1];
							System.out.printf("이름:%s 연락처:%s 성별:%s입니다 \n", name, tel, findgender);
						}
					}
				}
				  break;
			case 4:
				System.out.print("삭제할 이름을 입력하세요");
				String rmname = scn.nextLine();
				for(int i = 0; i < friendAry.length; i++) {
					if(friendAry[i] != null) {
						String removename = friendAry[i].split(",")[0];
						if(rmname .equals(removename)) {
						  
						}
					}
					
				}
				break;
			case 5:
				
			case 9:
			}

		}
	}
}
