package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

	@Test
	public void add() {
		Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
		PassportOffice office = new PassportOffice();
		office.add(citizen);
		office.add(citizen);
		assertThat(office.get(citizen.getPassport()), is(citizen));
	}

	@Test
	public void addTrue() {
		Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
		PassportOffice office = new PassportOffice();
		assertThat(office.add(citizen), is(true));
	}

	@Test
	public void addFalse() {
		Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
		Citizen citizen2 = new Citizen("2f44a", "Petr Arsentev");
		PassportOffice office = new PassportOffice();
		office.add(citizen);
		boolean actual = office.add(citizen2);
		assertThat(actual, is(false));
	}
}