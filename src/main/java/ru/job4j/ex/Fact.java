package ru.job4j.ex;

public class Fact {
	public static void main(String[] args) {
		System.out.println("integral :" + calk(-10));
	}

	public static int calk(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Factorial value cannot be less than 0");
		}
		int rsl = 1;
		for (int index = 1; index <= n; index++) {
			rsl *= index;
		}
		return rsl;
	}
}
