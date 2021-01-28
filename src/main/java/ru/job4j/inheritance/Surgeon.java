package ru.job4j.inheritance;

public class Surgeon extends Doctor {
	private String department;

	public Surgeon(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	public void cut() {

	}
}
