package example;

public class MaxLengthSeria {
	public static int find(int[] array) {
		if (array.length == 0) {
			return 0;
		}
	var count = 1;
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index] <= array[index + 1]) {
				count++;
			} else {
				count = 1;
			}
		}
		return count;
	}
}
