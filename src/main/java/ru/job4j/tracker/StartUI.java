package ru.job4j.tracker;

public class StartUI {
	public void init(Input input, Tracker tracker, UserAction[] actions) {
		boolean run = true;
		while (run) {
			this.showMenu(actions);
			int select = input.askInt("Select: ");
			UserAction action = actions[select];
			run = action.execute(input, tracker);
		}
	}

	private void showMenu(UserAction[] actions) {
		System.out.println("Menu. ");
		for (int index = 0; index < actions.length; index++) {
			System.out.println(index + ". " + actions[index].name());
		}
	}

	public static void findById(Input input, Tracker tracker) {
		System.out.println("4. Find item by Id"
				+ System.lineSeparator()
				+ "Enter id to FIND:");
		int id = input.askInt("Ent ID: ");
		Item findId = tracker.findById(id);
		if (tracker.findById(id) != null) {
			System.out.println("Result find by id: " + findId);
		} else {
			System.out.println("Error. Not found id: " + id);
		}
	}

	public static void findByName(Input input, Tracker tracker) {
		System.out.println("Find items by name"
				+ System.lineSeparator()
				+ "Enter name to FIND:");
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
	}

	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		UserAction[] actions = {
				new CreateAction(),
				new ShowAllItemsAction(),
				new EditItemAction(),
				new DeleteItemAction(),
				new FindByIdAction(),
				new FindByNameAction(),
				new ExitAction()
		};
		new StartUI().init(input, tracker, actions);
	}
}
