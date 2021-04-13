package example;

import java.util.Arrays;

public class ArrayWithoutEvenElements {
	public static int[] changeData(int[] data) {
		int count = 0;
		int[] rsl = new int[0];
		for (int index = 0; index < data.length; index++) {
			if (data[index] % 2 != 0) {
				rsl = Arrays.copyOf(rsl, ++count);
				rsl[count - 1] = data[index];
			}
		}
		return rsl;
	}
}
