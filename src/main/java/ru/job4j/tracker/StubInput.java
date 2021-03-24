package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
	private List<String> answer;
	private int position = 0;

	public StubInput(List<String> answer) {
		this.answer = answer;
	}

	@Override
	public String askStr(String questions) {
		return answer.get(position++);
	}

	@Override
	public int askInt(String questions) {
		return Integer.parseInt(askStr(questions));
	}
}
