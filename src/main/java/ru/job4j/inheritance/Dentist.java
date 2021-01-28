package ru.job4j.inheritance;

public class Dentist extends Doctor {
	private int salary;

	public Dentist(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	public void treatTeeth() {

	}
}
