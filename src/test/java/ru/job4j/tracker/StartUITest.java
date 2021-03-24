package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
	private final List<UserAction> actions = new ArrayList<>();
	private final List<String> answer = new ArrayList<>();

	@Test

	public void whenExitProgram() {
		//List<String> answer = new ArrayList<>();
		answer.add("0");
		Output out = new StubOutput();
		Input in = new StubInput(answer);
		Tracker tracker = Tracker.getInstance();
		actions.add(new ExitAction(out));
//		UserAction[] actions = {
//				new ExitAction(out)
//		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				 "0. =Exit program=\r\n"
		));
	}

	@Test
	public void whenShowAllItems() {
		//List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add("1");
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();
		String showAllItems = "ShowAllItems item";
		Item item = tracker.add(new Item(showAllItems));
		Input in = new StubInput(answer);
		actions.add(new ShowAllItemsAction(out));
		actions.add(new ExitAction(out));
//		UserAction[] actions = {
//				new ShowAllItemsAction(out),
//				new ExitAction(out)
//		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName(), is(showAllItems));
	}

	@Test
	public void whenFindByName() {
		String findByName = "Find";
		answer.add("0");
		answer.add(findByName);
		answer.add("1");
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();

		Item item = tracker.add(new Item(findByName));
		tracker.add(new Item(findByName));
		Input in = new StubInput(answer);
		actions.add(new FindByNameAction(out));
		actions.add(new ExitAction(out));
//		UserAction[] actions = {
//				new FindByNameAction(out),
//				new ExitAction(out)
//		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName(), is(findByName));
	}

	@Test
	public void whenFindById() {
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();
		String findById = "FindId";
		Item item = tracker.add(new Item(findById));
		answer.add("0");
		answer.add(String.valueOf(item.getId()));
		answer.add("1");
		Input in = new StubInput(answer);
		actions.add(new FindByIdAction(out));
		actions.add(new ExitAction(out));
//		UserAction[] actions = {
//				new FindByIdAction(out),
//				new ExitAction(out)
//		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(item.getId(), is(1));
	}

	@Test
	public void whenInvalidExit() {
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();
		answer.add("9");
		answer.add("0");
		Input in = new StubInput(answer);
		actions.add(new ExitAction(out));
//		UserAction[] actions = {
//				new ExitAction(out)
//		};
		new StartUI(out).init(in, tracker, actions);
		Assert.assertThat(out.toString(), is((
				"0. =Exit program=" + System.lineSeparator()
				+ "Wrong input !!! Enter from 0 to 0" + System.lineSeparator()
				+ "0. =Exit program=" + System.lineSeparator()
				)
		));
	}
}
