package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
	private final Output out;

	public ShowAllItemsAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "===show all Items===";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		Item[] selectFindAll = tracker.findAll();
		for (Item result : selectFindAll) {
			out.println(result);
		}
		return true;
	}
}
