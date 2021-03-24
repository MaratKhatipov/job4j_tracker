package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
	private final Output out;

	public FindByNameAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "===Find items by name==="
				+ "(Enter name to FIND)";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("Enter name to find");
		String findName = input.askStr("enter name to find");
		List<Item> resultFindName = tracker.findByName(findName);
		if (resultFindName.size() > 0) {
			for (Item result : resultFindName) {
				out.println("Result find by name - "
						+ findName
						+ result);
			}
		} else {
			out.println("Result not found: " + findName);
		}
		return true;
	}
}
