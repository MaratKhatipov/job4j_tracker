package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DepartmentsTest {
	@Test
	public void whenMissed() {
		List<String> input = List.of("k1/sk1");
		List<String> expect = List.of("k1", "k1/sk1");
		List<String> result = Departments.fillGaps(input);
		assertThat(result, is(expect));
	}

	@Test
	public void whenNonChange() {
		List<String> input = List.of("k1", "k1/sk1");
		List<String> expect = List.of("k1", "k1/sk1");
		List<String> result = Departments.fillGaps(input);
		assertThat(result, is(expect));
	}

	@Test
	public void fillGaps() {
		List<String> deps = new ArrayList<>(List.of("K1/SK1/SSK1", "K2/SK2"));
		List<String> expected = new ArrayList<>(List.of("K1", "K1/SK1", "K1/SK1/SSK1",
				"K2", "K2/SK2"));
		assertThat(Departments.fillGaps(deps), is(expected));
	}
}