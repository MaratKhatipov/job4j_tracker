package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

	public static void main(String[] args) {
		Item predmet = new Item();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
				"dd-MMMM-EEEE-yyyy HH:mm:ss");
		System.out.println(predmet.getCreated().format(formatter));
	}
}
