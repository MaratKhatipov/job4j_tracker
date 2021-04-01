package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
	@Override
	public int compare(String left, String right) {
		String[] firstStr = left.split("\\D+");
		String[] secondStr = right.split("\\D+");
		for (int i = 0; i < Math.min(firstStr.length, secondStr.length); i++) {
			Integer leftNum = Integer.parseInt(firstStr[i]);
			int rightNum = Integer.parseInt(secondStr[i]);
			if (leftNum != rightNum) {
				return leftNum.compareTo(rightNum);
			}
		}
		return Integer.compare(firstStr.length, secondStr.length);
	}

}
