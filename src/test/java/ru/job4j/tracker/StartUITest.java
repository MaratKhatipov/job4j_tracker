//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsNull.nullValue;
//import static org.junit.Assert.*;
//
//public class StartUITest {
//
//	@Test
//	public void createItem() {
//		String[] answer = {"create a new task "};
//		Input input = new StubInput(answer);
//		Tracker tracker = new Tracker();
//		StartUI.createItem(input, tracker);
//		Item created = tracker.findAll()[0];
//		Item expected = new Item("create a new task ");
//		assertThat(created.getName(), is(expected.getName()));
//	}
//
//	@Test
//	public void whenReplaceItem() {
//		Tracker tracker = new Tracker();
//		Item item = new Item("new item");
//		tracker.add(item);
//		String[] answers = {
//				String.valueOf(item.getId()),
//				"replaced item"
//		};
//		StartUI.editItem(new StubInput(answers), tracker);
//		Item replaced = tracker.findById(item.getId());
//		assertThat(replaced.getName(), is("replaced item"));
//	}
//
//	@Test
//	public void deleteItem() {
//		Tracker tracker = new Tracker();
//		Item item = new Item("new item");
//		tracker.add(item);
//		String[] answers = {
//				String.valueOf(item.getId())
//		};
//		StartUI.deleteItem(new StubInput(answers), tracker);
//		Item deleted = tracker.findById(item.getId());
//		assertThat(deleted, is(nullValue()));
//	}
//}