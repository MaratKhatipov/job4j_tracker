package ru.job4j.polymorphism;

public class Technics {
	public static void main(String[] args) {
		Vehicle ty134 = new Airplan(": TY134");
		Vehicle boing = new Airplan(": BOING");
		Vehicle vl10 = new Train(": VL10");
		Vehicle vl80T = new Train(": VL80T");
		Vehicle ikarus = new Bus(": IKARUS");
		Vehicle nefaz = new Bus(": NEFAZ");
		Vehicle[] vehicles = new Vehicle[]{ty134, boing, vl10, vl80T, ikarus, nefaz};
		for (Vehicle a: vehicles) {
			a.move();
			a.characteristicsFuel();
		}

	}
}
