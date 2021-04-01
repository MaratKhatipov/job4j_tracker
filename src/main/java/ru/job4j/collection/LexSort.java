package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
	@Override
	public int compare(String left, String right) {
		String[] firstStr = left.split("\\D+");
		String[] secondStr = right.split("\\D+");
		int leftNum = Integer.parseInt(firstStr[0]);
		int rightNum = Integer.parseInt(secondStr[0]);
		return Integer.compare(leftNum, rightNum);

	}

}
