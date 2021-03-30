package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorted {
	public static void main(String[] args) {
		List<Item> items = Arrays.asList(
				new Item(4, "C"),
				new Item(2, "F"),
				new Item(1, "E")
        );
		System.out.println(items);

		Collections.sort(items);
		System.out.println(items);

		items.sort(Collections.reverseOrder());
		System.out.println(items);
	}
}
