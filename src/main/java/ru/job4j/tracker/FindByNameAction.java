package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
	public FindByNameAction(Output out) {
		this.out = out;
	}

	private final Output out;

	@Override
	public String name() {
		return "===Find items by name==="
				+ "(Enter name to FIND)";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("Enter name to find");
		String findName = input.askStr("enter name to find");
		Item[] resultFindName = tracker.findByName(findName);
		if (resultFindName.length > 0) {
			for (Item result : resultFindName) {
				System.out.println("Result find by name - "
						+ findName
						+ result);
			}
		} else {
			System.out.println("Result not found: " + findName);
		}
		return true;
	}
}
