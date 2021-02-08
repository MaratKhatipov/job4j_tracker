package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

	@Test
	public void createItem() {
		String[] answer = {"create a new task "};
		Input input = new StubInput(answer);
		Tracker tracker = new Tracker();
		StartUI.createItem(input, tracker);
		Item created = tracker.findAll()[0];
		Item expected = new Item("create a new task ");
		assertThat(created.getName(), is(expected.getName()));
	}
}