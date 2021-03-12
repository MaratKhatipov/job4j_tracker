package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

	@Test
	public void whenFindByName() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		ArrayList<Person> persons = phones.find("Pe");
		assertThat(persons.get(0).getSurname(), is("Arsentev"));
	}

	@Test
	public void whenFindByPhone() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		ArrayList<Person> persons = phones.find("48");
		assertThat(persons.get(0).getAddress(), is("Bryansk"));
	}

	@Test
	public void whenNotFindBy() {
		PhoneDictionary phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		ArrayList<Person> persons = phones.find("12");
		int res = persons.size();
		assertThat(res, is(0));
	}
}