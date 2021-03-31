package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/*
* whenCompactorByNameAndPriority - тест комбинированного компаратора
* descByName,  deskByPriority - тест компоратора по убыванию
* ascByName,  ascByPriority - тест компаратора по возрастанию
*
* */
public class JobTest {

	@Test
	public void whenCompactorByNameAndPriority() {
		Comparator<Job> cmpNamePriority =
				new JobDescByName().thenComparing(
						new JobDescByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("Impl task", 0),
				new Job("Fix bug", 1)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void descByName() {
		Comparator<Job> sortByNameDesc =
				new JobDescByName();
		int rsl = sortByNameDesc.compare(
				new Job("ABC", 10),
				new Job("DEF", 15)
		);
		assertThat(rsl, greaterThan(0));
	}

	@Test
	public void ascByName() {
		Comparator<Job> sortByNameAsc =
				new JobAscByName();
		int rsl = sortByNameAsc.compare(
				new Job("Andrew", 10),
				new Job("Xzibit", 15)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void deskByPriority() {
		Comparator<Job> sortByPriorityDesk =
				new JobDescByPriority();
		int rsl = sortByPriorityDesk.compare(
				new Job("Andrew", 10),
				new Job("Xzibit", 15)
		);
		assertThat(rsl, greaterThan(0));
	}

	@Test
	public void ascByPriority() {
		Comparator<Job> sortByPriorityAsc =
				new JobAscByPriority();
		int rsl = sortByPriorityAsc.compare(
				new Job("Andrew", 10),
				new Job("Xzibit", 15)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenCompByNameSameAndPriority() {
		Comparator<Job> cmpNamePriority =
				new JobDescByName().thenComparing(
						new JobDescByPriority());
		int rsl = cmpNamePriority.compare(
				new Job("Ivan", 0),
				new Job("Ivan", 1)
		);
		assertThat(rsl, greaterThan(0));
	}

	@Test
	public void whenCompByPriorityAndName() {
		Comparator<Job> cmpPriorityName =
				new JobAscByPriority().thenComparing(
						new JobAscByName());
		int rsl = cmpPriorityName.compare(
				new Job("Ivan", 0),
				new Job("Ivan", 1)
		);
		assertThat(rsl, lessThan(0));
	}

	@Test
	public void whenSamePriorityAndName() {
		Comparator<Job> cmpPriorityName =
				new JobAscByPriority().thenComparing(
						new JobAscByName());
		int rsl = cmpPriorityName.compare(
				new Job("Ivan", 10),
				new Job("Ivan", 10)
		);
		assertThat(rsl, equalTo(0));
	}
}