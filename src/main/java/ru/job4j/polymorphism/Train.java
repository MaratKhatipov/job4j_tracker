package ru.job4j.polymorphism;

public class Train implements Vehicle {
	private String name;

	public Train(String name) {
		this.name = name;
	}

	@Override
	public void move() {
		System.out.println(
				getClass().getSimpleName() + name
				+ ": Передвигается по рельсам");
	}

	@Override
	public void characteristicsFuel() {
		System.out.println(
				getClass().getSimpleName()
						+ name
						+ ": Имеется пантограф, "
						+ "двигается за счёт электричества");
	}
}
