package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
	private final List<String> answer = new ArrayList<>();

	@Test
	public void whenInvalidInput() {
		Output out = new StubOutput();
		answer.add("one");
		answer.add("1");
		Input in = new StubInput(answer);
//		Input in = new StubInput(
//				new String[]{"one", "1"}
//		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Menu. ");
		assertThat(selected, is(1));
	}

	@Test
	public void whenValidInput() {
		Output out = new StubOutput();
		answer.add("1");
		Input in = new StubInput(answer);
//		Input in = new StubInput(
//				new String[]{"1"}
//		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Menu. ");
		assertThat(selected, is(1));
	}

	@Test
	public void whenValidInputMultiple() {
		Output out = new StubOutput();
		answer.add("0");
		answer.add("1");
		answer.add("0");
		answer.add("3");
		Input in = new StubInput(answer);
//		String[] inStrings = new String[] {"0", "1", "0", "3"};
//		Input in = new StubInput(inStrings);
		ValidateInput input = new ValidateInput(out, in);
//		int[] expected = new int[]{0, 1, 0, 3};
		List<Integer> expected = new ArrayList<>();
		expected.add(0);
		expected.add(1);
		expected.add(0);
		expected.add(3);
		for (int i = 0; i < answer.size(); i++) {
			int selected = input.askInt("Menu. ");
			assertThat(selected, is(expected.get(i)));
		}
//		for (int index = 0; index < inStrings.length; index++) {
//			int selected = input.askInt("Menu. ");
//			assertThat(selected, is(expected[index]));
//		}
	}

	@Test
	public void whenValidInputMinus() {
		Output out = new StubOutput();
		answer.add("-1");
		Input in = new StubInput(answer);
//		Input in = new StubInput(
//				new String[]{"-1"}
//		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Menu. ");
		assertThat(selected, is(-1));
	}
}
