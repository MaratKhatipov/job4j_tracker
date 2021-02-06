package ru.job4j.tracker;

public class StartUI {
	public void init(Input input, Tracker tracker) {
		boolean run = true;
		while (run) {
			this.showMenu();
			System.out.println("Select: ");
			int select = input.askInt("Select1231231: ");
			switch (select) {
				case 0:
					System.out.println("=== Create a new Item ====");
					System.out.print("Enter name: ");
					String name = input.askStr("Enter name:"); //
					Item item = new Item(name);
					tracker.add(item);
					System.out.println("Create a new: " + item);
					break;
				case 1:
					System.out.println("1. Show all items: ");
					Item[] selectFindAll = tracker.findAll();
					for (Item result : selectFindAll) {
						System.out.println(result);
					}
					break;
				case 2:
					System.out.println("2. Edit item :"
							+ System.lineSeparator()
							+ "Enter id to edit:");
					int id = input.askInt("Enter ID: ");
					System.out.println("Enter new NAME");
					String newName = input.askStr("New name");
					Item newApplication = new Item(newName);
					if (tracker.replace(id, newApplication)) {
						System.out.println("Editing was successful");
					} else {
						System.out.println("Error. Editing failed ");
					}
					break;
				case 3:
					System.out.println("3. Delete item"
							+ System.lineSeparator()
							+ "Enter id to delete:");
					int delId = input.askInt("Enter ID :");
					Item dellItem = new Item(delId);
					if (tracker.delete(delId)) {
						System.out.println(
								"Delete was successful: "
								+ delId);
					} else {
						System.out.println(
								"Error. Delete failed: "
								+ delId);
					}
					break;
				case 4:
					System.out.println("4. Find item by Id"
							+ System.lineSeparator()
							+ "Enter id to FIND:");
					id = input.askInt("Ent ID: ");
					Item item2 = new Item(id);
					Item findId = tracker.findById(id);
					if (tracker.findById(id) != null) {
						System.out.println("Result find by id: " + findId);
					} else {
						System.out.println("Error. Not found id: " + id);
					}
					break;
				case 5:
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
					break;
				case 6:
					run = false;
					break;
				default :
					System.out.println("!!! Incorrect  entry !!!");
					break;
			}
		}
	}

	private void showMenu() {
		System.out.println("Menu. ");
		System.out.print(
				"0. Add new Item\n"
				+ "1. Show all items\n"
				+ "2. Edit item\n"
				+ "3. Delete item\n"
				+ "4. Find item by Id\n"
				+ "5. Find items by name\n"
				+ "6. Exit Program\n"
				);
	}

	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI().init(input, tracker);
	}
}
