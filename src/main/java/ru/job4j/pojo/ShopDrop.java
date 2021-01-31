package ru.job4j.pojo;

public class ShopDrop {
	public static Product[] leftShift(Product[] products, int index) {
		while (index < products.length) {
			if (index != 0) {
				products[index] = null;
			} else {
				products[index] = products[index + 1];
			}
			index++;
		}
		return products;
	}
}
