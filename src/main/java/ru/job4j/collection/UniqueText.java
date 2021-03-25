package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
	public static boolean isEquals(String originText, String duplicateText) {
		String[] origin = originText.split(" ");
		String[] text = duplicateText.split(" ");
		HashSet<String> check = new HashSet<>();
		for (String indexText : origin) {
			check.add(indexText);
		}
		for (String index :text) {
			if (!check.contains(index)) {
				return false;
			}
		}
		return true;
	}
}
