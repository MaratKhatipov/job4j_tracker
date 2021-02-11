package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
	@Override
	public String name() {
		return "===Find item by Id==="
				+ "(Enter id to FIND)";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("Enter ID to find");
		int id = input.askInt("Ent ID: ");
		Item findId = tracker.findById(id);
		if (findId != null) {
			System.out.println("Result find by id: " + findId);
		} else {
			System.out.println("Error. Not found id: " + id);
		}
		return true;
	}
}
