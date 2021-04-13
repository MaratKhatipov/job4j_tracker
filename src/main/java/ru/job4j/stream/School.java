package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
	List<Student> collect(
			List<Student> students,
						  Predicate<Student> predic) {
		return students
				.stream()
				.filter(predic)
				.collect(Collectors.toList());
	}
}
/*
students
.stream() - создаём стрим List<Student> students
.filter(predic) - вызываем метод фильтр, реализацию делаем в тесте
.collect(Collectors.toList()); - полученный результат сохраняем в коллекции List

 */