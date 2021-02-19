package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
	@Override
	public int askInt(String questions) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.askInt(questions);
				invalid = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Pleases enter validate data again!!! ");
			}
		} while (invalid);
		return value;
	}
}
