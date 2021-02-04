package ru.job4j.poly;

public interface Transport {
	void ride();

	void passenger(int passengerNumb);

	int refuel(int fuelQuantity);
}
