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
				new Item(4, "C"),
				new Item(2, "F"),
				new Item(1, "E")
		);
		Collections.sort(items);
		assertThat(items.toString(), is("[ Item {id = 1, name = 'E'},  "
				+ "Item {id = 2, name = 'F'},  "
				+ "Item {id = 4, name = 'C'}]")
		);
	}

	@Test
	public void sortDescending() {
		List<Item> items = Arrays.asList(
				new Item(4, "C"),
				new Item(2, "F"),
				new Item(1, "E")
		);
		items.sort(Collections.reverseOrder());
		assertThat(items.toString(), is("[ Item {id = 4, name = 'C'},  "
				+ "Item {id = 2, name = 'F'},  "
				+ "Item {id = 1, name = 'E'}]")
		);
	}
}