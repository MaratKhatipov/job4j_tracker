package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
	public void init(Scanner scanner, Tracker tracker) {
		boolean run = true;
		while (run) {
			this.showMenu();
			System.out.println("Select: ");
			int select = Integer.valueOf(scanner.nextLine());
			switch (select) {
				case 0:
					System.out.println("=== Create a new Item ====");
					System.out.print("Enter name: ");
					String name = scanner.nextLine();
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
					int id = scanner.nextInt();
					System.out.println("Enter new NAME");
					String newName = scanner.nextLine();
					Item newApplication = new Item(scanner.nextLine());
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
					int delId = scanner.nextInt();
					Item dellItem = new Item(scanner.nextLine());
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
					id = scanner.nextInt();
					Item item2 = new Item(scanner.nextLine());
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
					String findName = scanner.nextLine();
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
					System.out.println("!!! Incorrect ID entry !!!");
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
				+ "Select: ");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tracker tracker = new Tracker();
		new StartUI().init(scanner, tracker);
	}
}
