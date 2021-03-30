package ru.job4j.tracker;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ItemSortedTest {

	@Test
	public void whenByName1lessName2() {
		Comparator<Item> cmpName = new SortByNameItem();
		int rsl = cmpName.compare(
				new Item("Alex"),
				new Item("Ivan")
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenByName2lessName1() {
		Comparator<Item> cmpName = new SortByNameItem();
		int rsl = cmpName.compare(
				new Item("Ivan"),
				new Item("Alex")
		);
		assertThat(rsl, greaterThan(0));
	}

	@Test
	public void whenNameEquals() {
		Comparator<Item> cmpName = new SortByNameItem();
		int rsl = cmpName.compare(
				new Item("Alex"),
				new Item("Alex")
		);
		assertThat(rsl, equalTo(0));
	}

	@Test
	public void whenName1lessName2() {
		Comparator<Item> cmpName = new SortedReversName();
		int rsl = cmpName.compare(
				new Item("Ivan"),
				new Item("Alex")
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenName2lessName1() {
		Comparator<Item> cmpName = new SortedReversName();
		int rsl = cmpName.compare(
				new Item("Alex"),
				new Item("Ivan")
		);
		assertThat(rsl, greaterThan(0));
	}

	@Test
	public void whenNameEquals2() {
		Comparator<Item> cmpName = new SortedReversName();
		int rsl = cmpName.compare(
				new Item("Alex"),
				new Item("Alex")
		);
		assertThat(rsl, equalTo(0));
	}
}