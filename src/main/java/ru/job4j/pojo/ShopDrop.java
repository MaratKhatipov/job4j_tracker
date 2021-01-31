package ru.job4j.pojo;

public class ShopDrop {
	public static Product[] leftShift(Product[] products, int index) {
		for (int i = index; index < products.length - 1; index++) {
			products[i] = products[i + 1];
		}
		products[products.length - 1] = null;
		return products;

	}
}
