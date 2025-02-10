package com.yedam.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileExe2 {
	public static void main(String[] args) {
		// 보조스트림(입출력스트림)
		try {
			Reader reader = new FileReader("c:/temp/students.txt");
			BufferedReader br = new BufferedReader(reader);	
			
			while(true) {				
				String str = br.readLine(); // 한라인씩 읽어오기.
				if(str == null) {
					break; // 반복문종료.
				}
				String[] strAry = str.split(" "); // 구분자(공백) 배열생성.
				System.out.println("이름: " + strAry[0]+ ",영어:"+strAry[1]+",수학:" + strAry[2]);
			}
			br.close();
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
