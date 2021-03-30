package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdItem implements Comparable<Item> {
	private Item item;
//	@Override
//	public int compareTo(Item first, Item second) {
//		return  Integer.compare(first.getId(), second.getId());
//	}

	@Override
	public int compareTo(Item o) {
		return Integer.compare(o.getId(), item.getId());
	}
}