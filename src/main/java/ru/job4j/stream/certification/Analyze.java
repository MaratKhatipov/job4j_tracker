package ru.job4j.stream.certification;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class Analyze - класс для подсчета статистики по аттестатам учеников
 */
public class Analyze {
	/**
	 * Метод averageScore вычисляет общий средний балл
	 * - flatMap() для преобразования в поток объектов Subject;
	 * - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
	 * - average() для расчета среднего бала по предмету;
	 * - orElse() для того чтобы вернуть значение по умолчанию.
	 * @param stream поток Pupil
	 * @return средний балл
	 */
	public static double averageScore(Stream<Pupil> stream) {
		return stream
				.flatMap(x -> x.getSubjects().stream())
				.mapToInt(Subject::getScore)
				.average()
				.orElse(0D);
	}
	/**
	 * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
	 * метод map() для преобразования в поток объектов класса Tuple,
	 * внутри метода содаём объекты Tuple();
	 * параметры констуктора объекта Tuple:
	 * имя текущего объекта Pupil;
	 * рассчитанный средний балл ;
	 * метод collect(), с помощью которого мы все соберем в коллекцию List.
	 * @param stream поток Pupil
	 * @return список из объекта Tuple (имя ученика и средний балл).
	 */

	public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
		return stream
				.map(tup -> new Tuple(
						tup.getName(), tup.getSubjects()
						.stream()
						.mapToInt(Subject::getScore)
						.average()
						.orElse(0D)
						)
				)
						.collect(Collectors.toList());
	}

	/**
	 * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
	 *  flatMap() для преобразования в поток объектов Subject;
	 *  метод collect(), в который мы передаем метод groupingBy()
	 *  (минимум с двумя параметрами) класса Collectors.
	 *  При этом карта собирается следующим образом: ключ - это имя предмета,
	 *  значение - средний балл по этому предмету для каждого ученика.
	 *  Для расчета среднего балла используется метод averagingDouble() класса Collectors;
	 *  после этого собранную карту мы разбираем с помощью entrySet()
	 *  и открываем поток с помощью stream();
	 *  полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
	 *  внутри метода создаваём объекты Tuple();
	 *  в конструктор мы будем передавать параметры с помощью методов:
	 *  getKey() и getValue() интерфейса Entry;
	 *  последний метод collect(), с помощью которого мы все соберем в коллекцию List.
	 * @param stream поток Pupil
	 * @return список из объекта Tuple (название предмета и средний балл).
	 */
	public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
		return stream
				.flatMap(s -> s.getSubjects().stream())
				.collect(Collectors.groupingBy(
						Subject::getName, LinkedHashMap::new,
								Collectors.averagingDouble(
										Subject::getScore)))
				.entrySet()
				.stream()
				.map(x -> new Tuple(x.getKey(), x.getValue()))
				.collect(Collectors.toList());
	}

	/**
	 * Метод bestStudent - возвращает лучшего ученика.
	 * Лучшим считается ученик с наибольшим баллом по всем предметам.
	 * для реализации данного метода можно использовать метод averageScoreBySubject
	 * за исключением следующих особенностей:
	 * в данном методе мы рассчитываем суммарный балл,
	 * а не средний - поэтому вместо average() использкем метод sum();
	 * терминальной операцией будет метод max(),
	 * в который будем передавать компаратор.
	 * При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
	 * orElse() для того чтобы вернуть значение по умолчанию.
	 * @param stream поток Pupil
	 * @return лучшего ученика
	 */
	public static Tuple bestStudent(Stream<Pupil> stream) {
		return stream
				.map(tup -> new Tuple(tup.getName(), tup.getSubjects()
				.stream()
				.mapToInt(Subject::getScore)
				.sum()))
				.max(Comparator.comparing(Tuple::getScore))
				.orElse(new Tuple("Неизвестно", 0));
	}

	/**
	 * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
	 * для реализации данного метода можно использовать метод averageScoreByPupil
	 * за исключением следующих особенностей:
	 * в данном методе мы рассчитываем суммарный балл,
	 * а не средний - поэтому вместо averagingDouble()
	 * используем метод summingDouble();
	 * терминальной операцией будет метод max(),
	 * в который будем передавать компаратор.
	 * При этом компаратор определит объект Tuple,
	 * у которого значение Score будет максимальным;
	 * orElse() для того чтобы вернуть значение по умолчанию.
	 * @param stream поток Pupil
	 * @return объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
	 */
	public static Tuple bestSubject(Stream<Pupil> stream) {
		return stream
				.flatMap(s -> s.getSubjects().stream())
				.collect(Collectors.groupingBy(Subject::getName,
						HashMap::new, Collectors
								.summingDouble(Subject::getScore))
				)
				.entrySet()
				.stream()
				.map(x -> new Tuple(x.getKey(), x.getValue()))
				.max(Comparator.comparing(Tuple::getScore))
				.orElse(new Tuple("Неизвестно", 0));
	}
}
