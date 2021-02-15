package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

	@Test
	public void whenExit() {
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
//	@Test
//	public void whenCreateItem() {
//		Input in = new StubInput(
//				new String[] {"0", "Item name", "1"}
//		);
//		Tracker tracker = new Tracker();
//		UserAction[] actions = {
//				new CreateAction(out),
//				new ExitAction()
//		};
//		new StartUI().init(in, tracker, actions);
//		assertThat(tracker.findAll()[0].getName(), is("Item name"));
//	}
//
//	@Test
//	public void whenReplaceItem() {
//	Tracker tracker = new Tracker();
//	Item item = tracker.add(new Item("Replaced item"));
//	String replacedName = "New item name";
//	Input in = new StubInput(
//			new String[] {"0", "1", replacedName, "1"}
//	);
//	UserAction[] actions = {
//			new EditItemAction(),
//			new ExitAction()
//	};
//	new StartUI().init(in, tracker, actions);
//	assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//	}
//
//	@Test
//	public void whenDeleteItem() {
//		Tracker tracker = new Tracker();
//		/* Добавим в tracker новую заявку */
//		Item item = tracker.add(new Item("Deleted item"));
//		/* Входные данные должны содержать ID добавленной заявки item.getId() */
//		Input in = new StubInput(
//				new String[] {"0", "1", "1"}
//		);
//		UserAction[] actions = {
//				new DeleteItemAction(),
//				new ExitAction()
//		};
//		new StartUI().init(in, tracker, actions);
//		assertThat(tracker.findById(item.getId()), is(nullValue()));
//	}

}