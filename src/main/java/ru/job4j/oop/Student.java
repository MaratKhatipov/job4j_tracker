package ru.job4j.oop;

public class Student {
	public void music() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Tra tra tra");
		}
	}

	public void song() {
		for (int i = 0; i < 3; i++) {
			System.out.println("I believe I can  fly");
		}
	}

	public static void main(String[] args) {
		Student petya = new Student();
		petya.music();
		petya.song();
	}
}
