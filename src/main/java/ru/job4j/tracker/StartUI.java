package ru.job4j.tracker;

public class StartUI {
	private final Output out;

	public StartUI(Output out) {
		this.out = out;
	}

	public void init(Input input, Tracker tracker, UserAction[] actions) {
		boolean run = true;
		while (run) {
			this.showMenu(actions);
			int select = input.askInt("Select: ");
			if (select < 0 || select >= actions.length) {
				out.println("Wrong input !!! Enter from 0 to "
						+
						(actions.length - 1));
				continue;
			}
			UserAction action = actions[select];
			run = action.execute(input, tracker);
		}
	}

	private void showMenu(UserAction[] actions) {
		System.out.println("Menu. ");
		for (int index = 0; index < actions.length; index++) {
			out.println(index + ". " + actions[index].name());
		}
	}

	public static void main(String[] args) {
		Output out = new ConsoleOutput();
		Input input = new ValidateInput(out, new ConsoleInput());
		Tracker tracker = Tracker.getInstance();
		UserAction[] actions = {
				new CreateAction(out),
				new ShowAllItemsAction(out),
				new EditItemAction(out),
				new DeleteItemAction(out),
				new FindByIdAction(out),
				new FindByNameAction(out),
				new ExitAction(out)
		};
		new StartUI(out).init(input, tracker, actions);
	}
}

