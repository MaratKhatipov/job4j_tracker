package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
	public static void main(String[] args) {
		System.out.print("I am the great Oracle. What do you want to know? ");
		Scanner yourQuestion = new Scanner(System.in);
		String question = yourQuestion.nextLine();
		int answer = new Random().nextInt(3);
		switch (answer) {
			case 0 -> System.out.println("YES");
			case 1 -> System.out.println("NO");
			default -> System.out.println("May be ");
		}
	}
}
