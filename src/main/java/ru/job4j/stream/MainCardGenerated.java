package ru.job4j.stream;

import java.util.stream.Stream;

public class MainCardGenerated {
	public static void main(String[] args) {
		Stream.of(Suit.values())
				.flatMap(s -> Stream.of(Value.values())
				.map(v -> v + " " + s))
				.forEach(System.out::println);
	}

}

