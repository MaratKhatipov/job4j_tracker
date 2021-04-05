package ru.job4j.collection;

import java.util.*;

/**
 * 2. Отсортировать департаменты [#442761]
 * Класс осуществляет добавление отсутсвующих подразделений,
 * а также производит сортировку этих подразделений
 */
public class Departments {
	/**
	 * Метод добавляет отсутвующие департаменты
	 * LinkedHashSet<>() используется для промежуточного хранения,
	 * коллекция LinkedHashSet<>() позволяет устранить дубликаты из коллекции
	 * @param deps входящий лист департаментов
	 * @return методот возвращает исправленную коллекуию департаментов
	 */
	public static List<String> fillGaps(List<String> deps) {
		Set<String> temp = new LinkedHashSet<>();
		for (String value : deps) {
			String start = "";
			for (String end : value.split("/")) {
				if (!start.equals("")) {
					start += "/" + end;
				} else {
					start = end;
				}
				temp.add(start);
			}
		}
		return new ArrayList<>(temp);
	}

	/**
	 * Сортировка по возрастанию
	 * @param orgs Коллекция для сортировки
	 */
	public static void sortAsc(List<String> orgs) {
		orgs.sort(Comparator.naturalOrder());
	}

	/**
	 * Сортировка по убыванию
	 *  нужно сравнить первые элементы по убыванию,
	 *  если они равны, то сравнить последующие элементы,
	 *  но в возрастающем порядке.
	 *  Для сортировки по убыванию реализован отдельный компаратор
	 * @see DepDescComp
	 * @param orgs Коллекция для сортировки
	 */
	public static void sortDesc(List<String> orgs) {
		orgs.sort(new DepDescComp());
	}
}