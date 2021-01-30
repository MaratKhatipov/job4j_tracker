package ru.job4j.pojo;

public class Library {
	public static void main(String[] args) {
		Book firstBook = new Book("java 8 the complete reference", 1377);
		Book secondBook = new Book("Effective Java", 466);
		Book thirdBook = new Book("grokking algorithms", 290);
		Book fourthBook = new Book("Clean Code", 1168);
		Book[] javaBook = new Book[4];
		javaBook[0] = firstBook;
		javaBook[1] = secondBook;
		javaBook[2] = thirdBook;
		javaBook[3] = fourthBook;
		for (int i = 0; i < javaBook.length; i++) {
			System.out.println(
					javaBook[i].getName()
							+ " - "
							+ javaBook[i].getNumberPages() + " pages"
			);
		}
		javaBook[0] = fourthBook;
		javaBook[3] = firstBook;
		System.out.println("Show only setName (Clean Code) ");
		for (int i = 0; i < javaBook.length; i++) {
			if (javaBook[i].getName().equals("Clean Code")) {
				System.out.println(
						javaBook[i].getName()
								+ " - "
								+ javaBook[i].getNumberPages()
								+ " pages"
				);
			}
		}
	}
}
