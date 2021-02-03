package ru.job4j.io;

import java.util.Scanner;

public class Matches {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Game 11");
		boolean turn = true;
		int count = 11;
		while (count > 0) {
			String player = turn ? " ГОМЕР СИМПСОН " : " БАРТ СИМПСОН ";
			System.out.println(player + " Введите числа от 1 до 3 ");
			int matches = Integer.parseInt(input.nextLine());
			turn = !turn;
			if (matches > 3 || matches < 1) {
				matches = 0;
				System.out.println("!!!ЧИТАЙ УСЛОВИЕ!!!"
						+ "!!!Вы ввели неверное число!!!");
				turn = !turn;
			}
			count = count - matches;
			if (count < 0) {
				count = count + matches;
				System.out.println("!!ТЫ РАЗВЕ НЕ ВИДИШЬ СКОЛЬКО СПИЧЕК ОСТАЛОСЬ!!"
								+
								", ВВЕДИТЕ МЕНЬШЕЕ ЧИСЛО");
				turn = !turn;
			}
			System.out.println("осталось: " + count + " спичек");
		}
		if (!turn) {
			System.out.println("Выиграл первый игрок");
		} else {
			System.out.println("Выиграл второй игрок");
		}
	}
}
