package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

	@Test
	public void whenInvalidInput() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"one", "1"}
		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Menu. ");
		assertThat(selected, is(1));
	}
}