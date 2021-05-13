package example.arrays;

public class Merge {
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;

		while (leftIndex < left.length && rightIndex < right.length) {

			if (left[leftIndex] < right[rightIndex]) {
				result[index] = left[leftIndex];
				leftIndex++;
			} else {
				result[index] = right[rightIndex];
				rightIndex++;
			}
			index++;
		}

		while (leftIndex < left.length) {
			result[index] = left[leftIndex];
			leftIndex++;
			index++;
		}

		while (rightIndex < right.length) {
			result[index] = right[rightIndex];
			rightIndex++;
			index++;
		}
		return result;
	}
}
