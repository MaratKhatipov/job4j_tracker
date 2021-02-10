package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
	@Override
	public String name() {
		return "===Delete item==="
				+ "(Enter id to delete)";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("Enter ID to delete");
		int delId = input.askInt("Enter ID :");
		if (tracker.delete(delId)) {
			System.out.println(
					"Delete was successful: "
							+ delId);
		} else {
			System.out.println(
					"Error. Delete failed: "
							+ delId);
		}
		return true;
	}
}
