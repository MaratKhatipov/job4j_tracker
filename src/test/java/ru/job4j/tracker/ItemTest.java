package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

	@Test
	public void sortAscending() {
		List<Item> items = Arrays.asList(
				new Item(4),
				new Item(2),
				new Item(1)
		);
		List<Item> expected = Arrays.asList(
				new Item(1),
				new Item(2),
				new Item(4)
		);
		Collections.sort(items);
		assertThat(expected, is(items));
	}

	@Test
	public void sortDescending() {
		List<Item> items = Arrays.asList(
				new Item(1),
				new Item(2),
				new Item(4)
		);
		List<Item> expected = Arrays.asList(
				new Item(4),
				new Item(2),
				new Item(1)
		);
		items.sort(Collections.reverseOrder());
		assertThat(expected, is(items));
	}
}