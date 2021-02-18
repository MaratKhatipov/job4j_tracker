package ru.job4j.ex;

public class FactRec {
	public static int calk(int n) {
		int result = 1;
		if (n == 1 || n == 0) {
			return result;
		} else {
			result = calk(n - 1) * n;
			return result;
		}
	}

	public static void main(String[] args) {
		int rsl = calk(3);
		System.out.println(rsl);
	}
}
