package ru.job4j.inheritance;

public class Builder extends Engineer {
	private String creating;

	public Builder(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	public void buildHouse() {

	}
}
