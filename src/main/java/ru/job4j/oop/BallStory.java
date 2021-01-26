package ru.job4j.oop;

public class BallStory {
	public static void main(String[] args) {
		Ball kolobok = new Ball();
		Hare zayac = new Hare();
		WolfWolf seryi = new WolfWolf();
		Fox ryjaya = new Fox();
		zayac.tryEat(kolobok);
		seryi.tryEat(kolobok);
		ryjaya.tryEat(kolobok);
	}
}
