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

	@Test
	public void whenValidInput() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"1"}
		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Menu. ");
		assertThat(selected, is(1));
	}

	@Test
	public void whenValidInputMultiple() {
		Output out = new StubOutput();
		String[] inStrings = new String[] {"0", "1", "0", "3"};
		Input in = new StubInput(inStrings);
		ValidateInput input = new ValidateInput(out, in);
		int[] expected = new int[]{0, 1, 0, 3};

		for (int index = 0; index < inStrings.length; index++) {
			int selected = input.askInt("Menu. ");
			assertThat(selected, is(expected[index]));
		}
	}

	@Test
	public void whenValidInputMinus() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[]{"-1"}
		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Menu. ");
		assertThat(selected, is(-1));
	}
}
