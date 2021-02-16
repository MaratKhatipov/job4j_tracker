package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

	private final Output out;

	public DeleteItemAction(Output out) {
		this.out = out;
	}

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
			out.println(
					"Delete was successful: "
							+ delId);
		} else {
			out.println(
					"Error. Delete failed: "
							+ delId);
		}
		return true;
	}
}
