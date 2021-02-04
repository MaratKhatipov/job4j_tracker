package ru.job4j.poly;

public class Bus implements Transport {

	@Override
	public void ride() {

	}

	@Override
	public void passenger(int passengerNumb) {

	}

	@Override
	public int refuel(int fuelQuantity) {
		int fuelPrice = 100;
		int price = fuelQuantity * fuelPrice;
		return price;
	}
}
