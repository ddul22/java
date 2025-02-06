package com.yedam.api;

public class StringUtil {

	static void 연결하기(String str, String str2) {
		System.out.println(str.concat(", ").concat(str2));
		// 문자열을 연결하는 메소드 "" + "" + ""
	}
	static void checkGender(String ssn) {
		// 성별을 출력. "남자입니다" 또는 "여자입니다"
		
	}
	static void checkExtension(String file) {
		// 파일의 확장자는 jpg (또는 mp3, hwp) 입니다.
		System.out.println(file.indexOf("."));
		String ext = file.substring(file.indexOf(".")+1);
		System.out.printf("파일의 확장자는 %s입니다.", ext);
	}
	static void getLength(String str) {
		// 문장의 길이는 7글자입니다.
		int len = str.trim().length();
		System.out.printf("문장의 길이는 %d글자입니다.", len);
	}
}
