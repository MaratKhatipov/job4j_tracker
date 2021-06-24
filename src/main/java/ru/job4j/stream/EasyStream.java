package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Экзамен. Lambda, Stream API, JDK Features.
 * EasyStream
 * Представьте, что разработчики JDK не сделали Stream API.
 * В этом задании Вам нужно реализовать каркас упрощенного Stream API.
 */

public class EasyStream {
	private final List<Integer> list = new ArrayList<>();

	private EasyStream(List<Integer> origin) {
		this.list.addAll(origin);
	}

	/**
	 * of - получает исходные данные.
	 */
	public static EasyStream of(List<Integer> source) {
		return new EasyStream(source);
	}

	/**
	 * map - преобразует число в другое число.
	 */
	public EasyStream map(Function<Integer, Integer> func) {
		List<Integer> mapInteger = new ArrayList<>();
		for (Integer value : list) {
			mapInteger.add(func.apply(value));
		}
		return new EasyStream(mapInteger);
	}

	/**
	 * filter - фильтрует поток элементов.
	 */
	public EasyStream filter(Predicate<Integer> testPred) {
		List<Integer> filterList = new ArrayList<>();
		for (Integer value : list) {
			if (testPred.test(value)) {
				filterList.add(value);
			}
		}
		return new EasyStream(filterList);
	}

	/**
	 * collect - собирает все элементы из source по заданным условиям map и filter.
	 */
	public List<Integer> collect() {
		return new ArrayList<>(this.list);
	}

}

