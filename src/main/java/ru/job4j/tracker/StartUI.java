package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
	private final Output out;

	public StartUI(Output out) {
		this.out = out;
	}

	public void init(
			Input input, Tracker tracker, List<UserAction> actions
	) {
		boolean run = true;
		while (run) {
			this.showMenu(actions);
			int select = input.askInt("");
			if (select < 0 || select >= actions.size()) {
				out.println("Wrong input !!! Enter from 0 to "
						+
						(actions.size() - 1));
				continue;
			}
			UserAction action = actions.get(select);
			run = action.execute(input, tracker);
		}
	}

	private void showMenu(List<UserAction> actions) {
		System.out.println("Menu. ");
		for (int index = 0; index < actions.size(); index++) {
			out.println(index + ". " + actions.get(index).name());
		}
	}

	public static void main(String[] args) {
		Output out = new ConsoleOutput();
		Input input = new ValidateInput(out, new ConsoleInput());
		Tracker tracker = Tracker.getInstance();
		List<UserAction> actions = new ArrayList<>();

		actions.add(new CreateAction(out));
		actions.add(new ShowAllItemsAction(out));
		actions.add(new EditItemAction(out));
		actions.add(new DeleteItemAction(out));
		actions.add(new FindByIdAction(out));
		actions.add(new FindByNameAction(out));
		actions.add(new ExitAction(out));

		new StartUI(out).init(input, tracker, actions);
	}
}

