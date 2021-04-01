package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
	public static void main(String[] args) {
		System.out.print("I am the great Oracle. What do you want to know? ");
		Scanner yourQuestion = new Scanner(System.in);
		String question = yourQuestion.nextLine();
		int answer = new Random().nextInt(3);
		if (answer == 1) {
			System.out.println("YES");
		} else if (answer == 2) {
			System.out.println("NO");
		} else {
			System.out.println("May be ");
		}
	}
}
