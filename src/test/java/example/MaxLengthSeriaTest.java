package example;

import org.junit.Test;

import static org.junit.Assert.*;
/*
* Если последовательность элементов удовлетворяет условию
* Ak <= Ak+1 <= ... <= Ak+m
* она называется неубывающей.
* Длина последовательности это количество элементов,
* которые в нее входят.
* В массиве таких последовательностей может быть несколько,
* вам нужно найти длину максимальной из них.
*/
public class MaxLengthSeriaTest {

	@Test
	public void find() {
		assertEquals(0, MaxLengthSeria.find(new int[0]));
		assertEquals(1, MaxLengthSeria.find(new int[] {1}));
		assertEquals(1, MaxLengthSeria.find(new int[] {2, 1}));
		assertEquals(2, MaxLengthSeria.find(new int[] {1, 2}));
		assertEquals(4, MaxLengthSeria.find(new int[] {1, 2, 0, 1, 2, 3}));
		assertEquals(4, MaxLengthSeria.find(new int[] {1, 2, 1, 1, 2, 3}));
		assertEquals(1, MaxLengthSeria.find(new int[] {3, 2, 1}));
	}
}