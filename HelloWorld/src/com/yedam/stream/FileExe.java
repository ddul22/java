package com.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileExe {
	public static void main(String[] args) {
		// ListExe.java 읽기.
		char txt;
		try {
			Reader reader = new FileReader("c:/temp/ListExe.java");
			while(true) {
				int chr = reader.read(); // char(2byte)
				System.out.print((char) chr); // 65 -> A
				if(chr == -1) {
					break;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog.");
	}

	void write() {
		// 문자기반 파일출력.
		try {
			Writer wr = new FileWriter("c:/temp/test2.txt");
			wr.write(65); // int매개값.
			wr.write(new char[] { 'B', 'C' });
			wr.write("DEFGHI", 2, 3);
			
			wr.flush();wr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 바이트기반 파일읽기.
	void input() {
		try {
			InputStream is = new FileInputStream("c:/temp/test1.dat");
			while (true) {
				int data = is.read(); // 바이트 읽고 반환. -1값 반환.
				System.out.println(data);
				if (data == -1) {
					break;
				}
				is.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일복사.
	void copy() {
		// c:/temp/sample.PNG -> c:/temp/copy.PNG 생성.
		try {
			InputStream is = new FileInputStream("c:/temp/sample.PNG");
			OutputStream os = new FileOutputStream("c:/temp/copy2.PNG");

			int data = -1;
			byte[] buf = new byte[100];
			while (true) {
				// 읽기.
				data = is.read(buf); // -1 반환.

				os.write(buf); // 출력(바이트 쓰기)

				if (data == -1) {
					break;
				}
			}
			is.close();
			os.flush();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 바이트기반 파일생성.
	void output() {
		// 출력스트림(바이트기반) OutputStream.
		try {
			OutputStream os = new FileOutputStream("c:/temp/test1.dat");
			os.write(10);
			os.write(20);
			os.write(30); // 쓰기.
			os.flush(); // 버퍼비우기.
			os.close(); // 리소스 반환.

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}