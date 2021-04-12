package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
	private ArrayList<Person> persons = new ArrayList<>();

	public void add(Person persons) {
		this.persons.add(persons);
	}

	public ArrayList<Person> find(String key) {
		Predicate<Person> personName = pers -> pers.getName().contains(key);
		Predicate<Person> personSurname = pers -> pers.getSurname().contains(key);
		Predicate<Person> personPhone = pers -> pers.getPhone().contains(key);
		Predicate<Person> personAddress = pers -> pers.getAddress().contains(key);
		Predicate<Person> combine =
				personName.
				or(personSurname).
				or(personPhone).
				or(personAddress);
		ArrayList<Person> result = new ArrayList<>();
		for (Person person : persons) {
			if (combine.test(person)) {
				result.add(person);
			}
		}
		return result;
	}
}

