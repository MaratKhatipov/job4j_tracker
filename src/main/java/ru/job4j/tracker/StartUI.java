package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

	public static void main(String[] args) {
		Item predmet = new Item();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
				"dd-MMMM-EEEE-yyyy HH:mm:ss");
		System.out.println(predmet.getCreated().format(formatter));

		Tracker tracker = new Tracker();
		tracker.add(new Item());
		int tmp = 2;
		System.out.println(tracker.findById(tmp));
		System.out.println("9. toString [#442871]");
		Item chekItem = new Item();
		System.out.println(chekItem.toString());
	}
}
