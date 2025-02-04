package com.yedam.inferitance;

import java.util.Scanner;

/*
 * 친구목록, 등록, 수정, 삭제
 * 수정: 이름, 연락처 입력.
 */
public class FriendExe {
	// 싱글톤.
	// 1.필드선언.
	private static FriendExe instance = new FriendExe();

	// 2.생성자 은닉.
	private FriendExe() {
	}

	// 3. 인스턴스 반환하는 메소드.
	public static FriendExe getInstance() {
		return instance;
	}

	Friend[] friends = new Friend[100]; // 저장공간.

	// 초기데이터.
	public void init() {
		friends[0] = new Friend("홍길동", "010-1111-2222");
		friends[1] = new UnivFriend("김민식", "010-3333-2222", "우리대학교", "복지학과");
		friends[2] = new ComFriend("박민규", "010-4444-2222", "인포젠", "");

	}

	Scanner scn = new Scanner(System.in);

	// 시작메소드.
	public void run() {
		init();
		boolean run = true;
		while (run) {

			System.out.println("1.친구목록 2.등록 3.수정 4.삭제 9.종료");
			System.out.print("메뉴선택>>");
			int menu = scn.nextInt();scn.nextLine();
			switch (menu) {
			case 1: // 목록.
				friendList();
				break;
			case 2: // 등록.
				addFriend();
				break;
			case 3: // 수정.
				editFriend();
				break;
			case 4: // 삭제.
				delFriend();
				break;
			case 9: // 종료.
				System.out.println("종료합니다");
				run = false;
			default:
				System.out.println("메뉴를 확인하세요");
			}
		}
	} // end of run().

	// 추가메소드.
	void friendList() {
		System.out.println("친구목록");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].showInfo());
				//
			}
		}
	} // end of friendList().

	// 친구: 이름, 연락처
	// 학교: 친구 + 학교명, 전공.
	// 회사: 친구 + 회사명, 부서.
	void addFriend() {
		boolean run2 = true;
		while (run2) {

			System.out.println("1.친구 2.학교친구 3.회사친구 4.종료");
			System.out.print("선택>> ");
			int choice = scn.nextInt(); // 1.엔터.
			scn.nextLine();
			
			if(choice == 4) {
				return;// 메소드 종료.
			}
			// 메뉴선택예외.
			if(choice > 3 || choice <1) {
				System.out.println("메뉴를 확인해주세요");
			continue;
			}
		
			// 이름, 연락처.
			String name = "";
			System.out.print("이름입력>> ");
			name = scn.nextLine();
			// 이름의 정상값의 범위.
			if(name.length() >= 2 && name.length() <=10) {
				break;
			} else {
				System.out.println("이름은 2글자 이상 10글자 이하...");
			}
			String phone = scn.nextLine();
			System.out.print("연락처입력>> ");

			Friend friend = null;
			if (choice == 1) {
				friend = new Friend(name, phone);

			} else if (choice == 2) { // 학교, 전공.
				System.out.println("학교를 입력하세요");
				String univ = scn.nextLine();
				System.out.println("전공을 입력하세요");
				String major = scn.nextLine();

				friend = new UnivFriend(name, phone, univ, major);
			} else if (choice == 3) { // 회사, 부서.
				System.out.println("회사를 입력하세요");
				String compname = scn.nextLine();
				System.out.println("부서를 입력하세요");
				String department = scn.nextLine();

				friend = new ComFriend(name, phone, compname, department);
			} else {

			}
			// 빈공간에 저장.
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					System.out.println("등록완료.");
					break;
				}
			}
		}
	} // end of addFriend().

	void editFriend() {
		// 친구연락처 변경. 작성
		System.out.println("수정할 친구의 이름을 입력하세요");
		String name = scn.nextLine();
		System.out.println("수정할 친구의 연락처를 입력하세요");
		String phone = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
		if(friends[i] != null && friends[i].getFriendName().equals(name)) {
			friends[i].setPhoneNumber(phone);
			
		}
		}
	} // end of editFriend().

	void delFriend() {
		System.out.println("친구삭제");
		// 친구연락처 변경. 작성
		System.out.println("삭제할 친구의 이름을 입력하세요");
		String name = scn.nextLine();
		for(int i = 0; i < friends.length; i++) {
		if(friends[i] != null && friends[i].getFriendName().equals(name)) {
			friends[i] = null;
		}
		}
	} // end of delFriend().
}
