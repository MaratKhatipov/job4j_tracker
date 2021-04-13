package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ListToMapTest {
	private final List<Student> students = List.of(
			new Student(10, "Surname1"),
			new Student(10, "Surname1"),
			new Student(40, "Surname4"),
			new Student(40, "Surname4"),
			new Student(50, "Surname5"),
			new Student(50, "Surname5"),
			new Student(70, "Surname7"),
			new Student(70, "Surname7"),
			new Student(90, "Surname9"),
			new Student(90, "Surname9")
	);

	@Test
	public void convertListToMap() {
		ListToMap sc = new ListToMap();

		Map<String, Student> rsl = sc.convertListToMap(students);
		Map<String, Student> expected = new HashMap<>();
		expected.put("Surname1", new Student(10, "Surname1"));
		expected.put("Surname4", new Student(40, "Surname4"));
		expected.put("Surname5", new Student(50, "Surname5"));
		expected.put("Surname7", new Student(70, "Surname7"));
		expected.put("Surname9", new Student(90, "Surname9"));

		assertThat(rsl, is(expected));
	}
}