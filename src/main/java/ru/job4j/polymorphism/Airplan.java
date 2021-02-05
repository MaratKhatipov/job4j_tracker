package ru.job4j.polymorphism;

public class Airplan implements Vehicle {
	private String name;

	public Airplan(String name) {
		this.name = name;
	}

	@Override
	public void move() {
		System.out.println(
				getClass().getSimpleName() + name
						+ ": Совершает перелеты");
	}

	@Override
	public void characteristicsFuel() {
		System.out.println(
				getClass().getSimpleName() + name
				+ ": Имеются крылья и турбодвигатели");
	}
}
