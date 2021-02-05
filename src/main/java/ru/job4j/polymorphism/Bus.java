package ru.job4j.polymorphism;

public class Bus implements Vehicle {
	private String name;

	public Bus(String name) {
		this.name = name;
	}

	@Override
	public void move() {
		System.out.println(
				getClass().getSimpleName() + name
						+
						": Передвигается по дорогам");
	}

	@Override
	public void characteristicsFuel() {
		System.out.println(
				getClass().getSimpleName() + name
						+ ": Перевозит людей, имеет много мест");
	}
}
