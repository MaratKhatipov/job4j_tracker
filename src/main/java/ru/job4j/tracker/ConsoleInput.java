package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
	private Scanner scanner = new Scanner(System.in);

	@Override
	public String askStr(String questions) { // String questions
		return scanner.nextLine();
	}

	@Override
	public int askInt(String questions) {
		return Integer.valueOf(askStr(questions)); //questions
	}
}
