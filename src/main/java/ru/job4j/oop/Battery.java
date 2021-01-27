package ru.job4j.oop;

public class Battery {
	private int load;

	public Battery(int charge) {
		this.load = charge;
	}

	public void exchange(Battery another) {
		another.load = another.load + this.load;
		this.load = 0;
		if (another.load > 100) {
			another.load = 100;
			System.out.println("Your battery is full");
		}
	}

	public static void main(String[] args) {
		Battery first = new Battery(100);
		Battery second = new Battery(5);
		System.out.println("Battery 1 = " + first.load + " Battery 2 = " + second.load);
		System.out.println();
		first.exchange(second);
		System.out.println("Battery 1 = " + first.load + " Battery 2 = " + second.load);
	}
}
