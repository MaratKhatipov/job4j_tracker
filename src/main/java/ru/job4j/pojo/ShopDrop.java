package ru.job4j.pojo;

public class ShopDrop {
	public static Product[] leftShift(Product[] products, int index) {
		for (int i = index; index < products.length; index++) {
			if (index != 0) {
				products[index] = null;
			} else {
				products[index] = products[index + 1];
			}
		}
		return products;

	}
}
