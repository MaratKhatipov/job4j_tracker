package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
	public static List<Folder> filterSize(List<Folder> list) {
		Predicate<Folder>  pred = f -> f.getSize() > 100;
		return filter(list, pred);
	}

	public static List<Folder> filterName(List<Folder> list) {
		Predicate<Folder> pred = f -> f.getName().contains("bug");
		return filter(list, pred);
	}

	public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
		List<Folder> result = new ArrayList<>();
		for (Folder fold : list) {
			if (pred.test(fold)) {
				result.add(fold);
			}
		}
		return result;
	}
}
