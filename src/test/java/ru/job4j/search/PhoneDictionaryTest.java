package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

	@Test
	public void whenFindByName1() {
		var phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		var persons = phones.find("Petr");
		assertThat(persons.get(0).getSurname(), is("Arsentev"));
	}

	@Test
	public void whenFindByName() {
		var phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		var persons = phones.find("Pe");
		assertThat(persons.get(0).getSurname(), is("Arsentev"));
	}

	@Test
	public void whenFindByPhone() {
		var phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		var persons = phones.find("48");
		assertThat(persons.get(0).getAddress(), is("Bryansk"));
	}

	@Test
	public void whenNotFindBy() {
		var phones = new PhoneDictionary();
		phones.add(
				new Person("Petr", "Arsentev",
						"534872", "Bryansk")
		);
		ArrayList<Person> persons = phones.find("12");
		var res = persons.size();
		assertThat(res, is(0));
	}
}
