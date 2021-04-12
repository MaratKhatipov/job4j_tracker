package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamUsage {
	public static void main(String[] args) {
		List<Integer> first = new ArrayList<>(list());
		List<Integer> result = first.stream().filter(
				num -> num > 0
		).collect(Collectors.toList());
		System.out.println(first);
		System.out.println(result);
	}

	public static List<Integer> list() {
		List<Integer> numbs = new ArrayList<>();
		Random randNum = new Random();
		int negNumber;
		int posNumber;
		for (int index = 0; index < 8; index++) {
			negNumber = -randNum.nextInt(6);
			posNumber = randNum.nextInt(7);
			numbs.add(negNumber);
			numbs.add(posNumber);
		}
		return numbs;
	}
}

/*
		List<Task> bugs = tasks.stream().filter(
		        task -> task.name.contains("Bug")
		).collect(Collectors.toList());

tasks.stream() - мы получаем из коллекции Stream или поток элементов.
filter(task -> task.name.contains("Bug")) - Каждый элемент передается в метод filter().
Если метод возвращает true, то элемент передается дальше,
задаем условие, чтобы пропускать только те задачи, которые содержат слово Bug
.collect(Collectors.toList()); - строка позволяет полученный результат
сохранить в коллекции типа List.
* */
