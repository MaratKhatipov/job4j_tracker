package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

	@Test
	public void whenExitProgram() {
		Output out = new StubOutput();
		Input in = new StubInput(
				new String[] {"0"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new ExitAction(out)
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
				"Menu." + System.lineSeparator()
						+ "0. Exit Program." + System.lineSeparator()
		));
	}

	@Test
	public void whenShowAllItems() {
		Output out = new StubOutput();
		Tracker tracker = new Tracker();
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
		Tracker tracker = new Tracker();
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
		Tracker tracker = new Tracker();
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
}