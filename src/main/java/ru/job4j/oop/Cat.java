package ru.job4j.oop;

public class Cat {
	private String food;
	private String name;
	public void show() {
		System.out.println("Cat name:" + this.name + " and this is cat food: " + this.food);
	}
	public void eat(String meat) {
		this.food = meat;
	}
	public void giveNick(String nick) {
		this.name = nick;
	}

	public static void main(String[] args) {
		Cat peppy = new Cat();
		Cat sparky = new Cat();
		Cat gav = new Cat();
		gav.giveNick("GAV");
		gav.eat("CUTLET");
		gav.show();
		System.out.println();
		Cat black = new Cat();
		black.giveNick("Vasyl");
		black.eat("FISH");
		black.show();
	}
}
