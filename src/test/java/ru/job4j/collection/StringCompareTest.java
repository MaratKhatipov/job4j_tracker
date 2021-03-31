package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StringCompareTest {

	private StringCompare compare1 = new StringCompare();

	@Test
	public void whenStringsAreEqualThenZero() {
		int rst = compare1.compare(
				"Ivanov",
				"Ivanov"
		);
		assertThat(rst, is(0));
	}

	@Test
	public void whenLeftLessThanRightResultShouldBeNegative() {
		int rst = compare1.compare(
				"Ivanov",
				"Ivanova"
		);
		assertThat(rst, lessThan(0));
	}

	@Test
	public void whenLeftGreaterThanRightResultShouldBePositive() {
		int rst = compare1.compare(
				"Petrov",
				"Ivanova"
		);
		assertThat(rst, greaterThan(0));
	}

	@Test
	public void secondCharOfLeftGreaterThanRightShouldBePositive() {
		int rst = compare1.compare(
				"Petrov",
				"Patrov"
		);
		assertThat(rst, greaterThan(0));
	}

	@Test
	public void secondCharOfLeftLessThanRightShouldBeNegative() {
		int rst = compare1.compare(
				"Patrova",
				"Petrov"
		);
		assertThat(rst, lessThan(0));
	}
}