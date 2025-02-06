package com.yedam.api;

public class TimeExe {
	public static void main(String[] args) {
		// ?분 ?초 합은 ? 입니다. 출력.
		// 1부터 10000000000 까지 250의 배수의 합을 구하는 시간.
		long start, end = 0;
		start = System.currentTimeMillis(); // 현재시간을 long반환.
		
		System.out.println(Integer.MAX_VALUE); 
		System.out.println(Long.MAX_VALUE);
		
		long sum = 0;
		for (long i = 1; i < 10000000000L; i++) {
			if(i % 250 == 0) {
				sum += i;
			}
		}
		end = System.currentTimeMillis();
		long jobTime =(end - start) / 1000; // 1/1000 초 => 초 환산.
		long min = jobTime / 60; // 걸린시간(분).
		long sec = jobTime % 60; // 걸린시간(초).
		System.out.printf("%d분 %d초, 합: %d\n", min, sec, sum);
	}
}
