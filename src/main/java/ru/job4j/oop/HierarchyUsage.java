package ru.job4j.oop;

public class HierarchyUsage {
	public static void main(String[] args) {
		/* создаем объекта класса Car. */
		Car newObjectCar = new Car();

		/* делаем приведение к типу родителя Transport. */
		Transport tp = newObjectCar;

		/* делаем приведение к типу родителя Object. */
		Object obj = newObjectCar;

		/* Приведение типа при создании объекта. */
		Object objCar = new Car();

		/* Приведение типа за счет понижения по иерархии. */
		Car carFromObject = (Car) objCar;

		/* Ошибка в приведении типа. */
		Object bicycle = new Bicycle();

		/*код завершится с ошибок приведения типов ClassCastException	*/
		Car cb = (Car) bicycle;
	}
}
