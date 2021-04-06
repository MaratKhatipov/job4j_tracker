package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
	public static void main(String[] args) {
		Comparator<String> cmpDescSize = (left, right)
				-> {
			System.out.println(
					"sort in descending order - "
					+ right.length() + " : " + left.length()
			);
			return Integer.compare(right.length(), left.length());
		};
		int rsl = cmpDescSize.compare("OOO", "oo");
	}
}
