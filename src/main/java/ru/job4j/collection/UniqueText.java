package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
	public static boolean isEquals(String originText, String duplicateText) {
		var origin = originText.split(" ");
		var text = duplicateText.split(" ");
		var check = new HashSet<>(Arrays.asList(origin));
		for (String indexDuplicateText :text) {
			if (!check.contains(indexDuplicateText)) {
				return false;
			}
		}
		return true;
	}
}

/*
 		boolean result = true;
		String[] origin = originText.split(" ");
		String[] text = duplicateText.split(" ");
		HashSet<String> check = new HashSet<>();
		for (String indexText : origin) {
			check.add(indexText);
		}
		for (String indexDuplicateText :text) {
			if (!check.contains(indexDuplicateText)) {
				result = false;
				return false;
			}
		}
		return true;
*/
