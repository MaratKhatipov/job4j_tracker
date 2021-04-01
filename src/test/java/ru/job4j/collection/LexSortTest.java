package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LexSortTest {
	@Test
	public void sortNum1and2and3() {
		String[] input = {
				"2. Task.",
				"3. Task.",
				"1. Task."
		};
		String[] out = {
				"1. Task.",
				"2. Task.",
				"3. Task."
		};
		Arrays.sort(input, new LexSort());
		assertThat(input, is(out));
	}

	@Test
	public void sortWithPoint() {
		String[] input = {
				"2.0.1 Task.",
				"2.0.5 Task.",
				"1. Task."
		};
		String[] out = {
				"1. Task.",
				"2.0.1 Task.",
				"2.0.5 Task."
		};
		Arrays.sort(input, new LexSort());
		assertThat(input, is(out));
	}

	@Test
	public void sortWithPoint2() {
		String[] input = {
				"1.9.1 Task.",
				"1.0.5 Task.",
				"1.3.4.5 Task."
		};
		String[] out = {
				"1.0.5 Task.",
				"1.3.4.5 Task.",
				"1.9.1 Task."
		};
		Arrays.sort(input, new LexSort());
		assertThat(input, is(out));
	}

	@Test
	public void sortWithPoint3() {
		String[] input = {
				"4.9.1 Task.",
				"1.0.5 Task.",
				"10.3.4.5 Task."
		};
		String[] out = {
				"1.0.5 Task.",
				"4.9.1 Task.",
				"10.3.4.5 Task."
		};
		Arrays.sort(input, new LexSort());
		assertThat(input, is(out));
	}
}