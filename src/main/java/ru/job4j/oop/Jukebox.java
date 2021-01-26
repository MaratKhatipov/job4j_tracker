package ru.job4j.oop;

public class Jukebox {
	public  void music(int position) {
		if (position == 1) {
			System.out.println("Пусть бегут неуклюже");
		} else if (position == 2) {
			System.out.println("Спокойной ночи");
		} else {
			System.out.println("Песня не найдена");
		}
	}

	public static void main(String[] args) {
		Jukebox trio = new Jukebox();
		int position = 1;
		int secondPos = 2;
		trio.music(position);
		System.out.println();
		trio.music(secondPos);
		System.out.println();
		trio.music(3);

	}
}
