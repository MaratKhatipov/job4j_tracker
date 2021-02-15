package ru.job4j.tracker;

public class EditItemAction implements UserAction {
	private final Output out;

	public EditItemAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "===Edit Item==="
				+ "(Enter id to edit)";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("Enter id to edit");
		int id = input.askInt("Enter ID: ");
		System.out.println("Enter new NAME");
		String newName = input.askStr("New name");
		Item newApplication = new Item(newName);
		if (tracker.replace(id, newApplication)) {
			System.out.println("Editing was successful");
		} else {
			System.out.println("Error. Editing failed ");
		}
		return true;
	}
}
