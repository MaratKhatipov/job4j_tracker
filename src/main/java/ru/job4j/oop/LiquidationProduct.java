package ru.job4j.oop;
/*
6. Почему наследование - это плохо [#442858]
Задание
1. Класс LiquidationProduct можно наследовать.
Измените класс так, чтобы его нельзя было наследовать.

Для этого перед классом ставим ключевое слово finial
 */

public final class LiquidationProduct {
	private Product product;

	public LiquidationProduct(String name, int price) {
		product = new Product(name, price);
	}

	public String label() {
		return product.label();
	}
}
