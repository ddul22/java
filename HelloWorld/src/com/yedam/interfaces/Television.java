package com.yedam.interfaces;
/*
 * RemoteControl 인터페이스의 구현클래스.
 */
public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV의 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV의 전원을 끕니다.");
	}

}
