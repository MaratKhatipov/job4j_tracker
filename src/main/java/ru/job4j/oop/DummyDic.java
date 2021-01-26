package ru.job4j.oop;

public class DummyDic {
	public String engToRus(String eng) {
		String say = "Неизвестное слово: ";
		return say + eng;
	}

	public static void main(String[] args) {
		DummyDic doll = new DummyDic();
		String word = doll.engToRus(" cucumber");
		System.out.println(word);
	}
}
