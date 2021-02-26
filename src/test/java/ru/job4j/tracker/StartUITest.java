package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

	@Test
	public void whenExitProgram() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[] {"0"}
		);
		Tracker tracker = Tracker.getInstance();
		UserAction[] actions = {
				new ExitAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				 "0. =Exit program=\r\n"
		));
	}

	@Test
	public void whenShowAllItems() {
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();
		String showAllItems = "ShowAllItems item";
		Item item = tracker.add(new Item(showAllItems));
		Input in = new StubInput(
				new String[] {"0", "1"}
		);
		UserAction[] actions = {
				new ShowAllItemsAction(out),
				new ExitAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName(), is(showAllItems));
	}

	@Test
	public void whenFindByName() {
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();
		String findByName = "Find";
		Item item = tracker.add(new Item(findByName));
		tracker.add(new Item(findByName));
		Input in = new StubInput(
				new String[] {"0", findByName, "1"}
		);
		UserAction[] actions = {
				new FindByNameAction(out),
				new ExitAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName(), is(findByName));
	}

	@Test
	public void whenFindById() {
		Output out = new StubOutput();
		Tracker tracker = Tracker.getInstance();
		String findById = "FindId";
		Item item = tracker.add(new Item(findById));
		Input in = new StubInput(
				new String[] {"0", String.valueOf(item.getId()), "1"}
		);
		UserAction[] actions = {
				new FindByIdAction(out),
				new ExitAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(item.getId(), is(1));
	}

	@Test
	public void whenInvalidExit() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[] {"1", "0"}
		);
		Tracker tracker = Tracker.getInstance();
		UserAction[] actions = {
				new ExitAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		Assert.assertThat(out.toString(), is((
				"0. =Exit program=\r\n"
				+ "Wrong input !!! Enter from 0 to 0\r\n"
				+ "0. =Exit program=\r\n"
				)
		));
	}

}
