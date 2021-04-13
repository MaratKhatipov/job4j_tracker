package ru.job4j.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyUsage {
	/*
	 * у нас есть класс и в нем определены 3 метода, которые выполняют проверки над строкой.
	 * Мы можем заметить, что у всех методов есть общее
	 * – все три метода возвращают один и тот же тип – boolean.
	 * Мы помним, что метод test интерфейса Predicate возвращает тип boolean
	 * – давайте перепишем наш код, создав метод, который будет принимать Predicate
	 * и выполняет проверки с нашими строками:
	 * */

	//	public boolean empty(String s) {
//		return s.isEmpty();
//	}
//
//	public boolean startWith(String s, String pref) {
//		return s.startsWith(pref);
//	}
//
//	public boolean contains(String s, String key) {
//		return s.contains(key);
//	}
	/*
	 * выходит что ранее существовавшие методы мы можем просто удалить,
	 * а наш универсальный метод check - вызывать с разными экземплярами Predicate
	 * – сделаем это и будем вызывать наш метод check() в методе main:
	 * */
	public boolean empty(String s) {
		return check(str -> str.isEmpty(), s);
	}

	public boolean startWith(String s, String pref) {
		return check(str -> str.startsWith(pref), s);
	}

	public boolean contains(String s, String key) {
		return check(str -> str.contains(key), s);
	}

	public boolean check(Predicate<String> pred, String s) {
		return pred.test(s);
	}

	public String transform(Function<String, String> fun, String s) {
		return fun.apply(s);
	}

	public static void main(String[] args) {
		StrategyUsage usage = new StrategyUsage();
		System.out.println(
				"Результат работы: " + usage.check(
						str -> str.isEmpty(), ""
				)
		);
		System.out.println(
				"Результат работы: " + usage.check(
						str -> str.startsWith("Fun"), "Functional interface"
				)
		);
		System.out.println(
				"Результат работы: " + usage.check(
						str -> str.contains("rn"), "Surname Name"
				)
		);
	/*
	* Т.е. у нас получается всего один метод,
	* и мы его можем вызывать с разными предикатами.
	* И в данном случае это позволило избежать дублирования кода.
	Представьте, что от заказчика пришло новое требование
	* – у нас должен существовать набор методов,
	* которые будут выполнять преобразования строк:
	1. Приводить все символы строки к верхнему регистру;
	2. Производит конкатенацию двух строк;
	3. Удаляет из строки все пробелы в начале и конце строки.
	* Вспомним, что для того, чтобы выполнить преобразования над данными
	* прекрасно подходит функциональный интерфейс Function.
	* В данном случае мы работаем со строками,
	* и на выходе работы методов мы будем также получать строку
	* – значит использовать будем интерфейс в таком виде – Function<String, String>:

		public String transform(Function<String, String> fun, String s) {
			return fun.apply(s);
		}

	 */
	/* и вызывать метод с разными экземплярами Function: */

 System.out.println(
		 "Строка после преобразования: " + usage.transform(
	str -> str.toUpperCase(), "aBCdEfghKLmnpRstU"
			)
			);
 System.out.println(
		 usage.transform(
	str -> str.concat("работает корректно."), "Строка после преобразования: "
			)
			);
System.out.println(
		"Строка после преобразования: " + usage.transform(
	str -> str.trim(), "    aBC dEfghK Lmnp RstU        "
			)
			);
	}
}

