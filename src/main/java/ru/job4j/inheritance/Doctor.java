package ru.job4j.inheritance;

public class Doctor extends Profession {
private String hospitalNum;

	public Doctor(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	public void treat() {

	}
}
