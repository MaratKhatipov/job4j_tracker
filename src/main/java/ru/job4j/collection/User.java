package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
	private String name;
	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/*  нужно реализовать метод compareTo
	* Он должен сравнить имена,
	* если они равны, то сравнить возраст. */
	@Override
	public int compareTo(User another) {
		if (name.equals(another.name)) {
			return Integer.compare(age, another.age);
		}
		return name.compareTo(another.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		User user = (User) obj;
		return age == user.age && Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
