package com.yedam.inferitance;

public class AnimalExe {
	public static void main(String[] args) {
		Animal animal = null;//new Animal();
		
		// 다형성.//
		animal = new Dog();
		animal.sound(); // 멍멍..
		
		animal = new Cat();
		animal.sound(); // 야옹..
	}
}
