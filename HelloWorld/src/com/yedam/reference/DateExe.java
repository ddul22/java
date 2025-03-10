package com.yedam.reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		// Date 기능.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		System.out.println(sdf.format(now));
		// 년도-월-일 시:분:초
		try { // 예외가 발생하더라도 catch구문을 실행하고 정상종료.
			now = sdf.parse("2024-12-25 12:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(now);
		System.out.println("end of prog.");
		
	}
}
