package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
	private final Output out;

	public FindByIdAction(Output out) {
		this.out = out;
	}

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
			out.println("Result find by id: " + findId);
		} else {
			out.println("Error. Not found id: " + id);
		}
		return true;
	}
}
