package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
	public void whenEqu1and2() {
		String[] input = {
				"2. Task.",
				"2. Task.",
				"1. Task."
		};
		String[] out = {
				"1. Task.",
				"2. Task.",
				"2. Task."
		};
		Arrays.sort(input, new LexSort());
		assertThat(input, is(out));
	}

	@Test
	public void whenEquals() {
		String[] input = {
				"20. exercise.",
				"20. goal.",
				"20. Task."
		};
		String[] out = {
				"20. exercise.",
				"20. goal.",
				"20. Task."
		};
		Arrays.sort(input, new LexSort());
		assertThat(input, is(out));
	}
}