package ru.job4j.tracker;

public class ValidateInput implements Input {
	private final Output out;
	private final Input in;

	public ValidateInput(Output out, Input in) {
		this.out = out;
		this.in = in;
	}

	@Override
	public String askStr(String questions) {
		return in.askStr(questions);
	}

	@Override
	public int askInt(String questions) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = in.askInt(questions);
				invalid = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Pleases enter validate data again!!! ");
			}
		} while (invalid);
		return value;
	}
}
