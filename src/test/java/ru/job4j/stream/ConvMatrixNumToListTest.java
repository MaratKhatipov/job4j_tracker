package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConvMatrixNumToListTest {

	@Test
	public void convert() {
		ConvMatrixNumToList matrix = new ConvMatrixNumToList();
		Integer[][] num = {{1, 2, 3}, {4, 5}, {6}, {7, 8}};
		List<Integer> actual = matrix.convert(num);
		List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		assertThat(actual, is(expected));
	}
}