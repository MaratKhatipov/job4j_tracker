package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

	@Override
	public int compare(String first, String second) {
		String[] strFirst = first.split("/");
		String[] strSecond = second.split("/");
		int value = strSecond[0].compareTo(strFirst[0]);
		if (value == 0) {
			value = first.compareTo(second);
		}
		return value;
	}
}