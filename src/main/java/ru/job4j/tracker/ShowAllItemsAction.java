package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
	@Override
	public String name() {
		return "===show all Items===";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		Item[] selectFindAll = tracker.findAll();
		for (Item result : selectFindAll) {
			System.out.println(result);
		}
		return true;
	}
}
