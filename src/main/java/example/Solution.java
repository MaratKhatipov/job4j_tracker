package example;

import java.util.Arrays;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] rsl = new int[2];
		boolean bol = false;
		for (int i = 0; i < nums.length; i++) {
			if (!bol) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						rsl = new int[]{i, j};
						bol = true;
						break;
					}
				}
			} else {
				break;
			}
		}
		return rsl;
	}

		public static void main(String[]args) {
		Solution song = new Solution();
		System.out.println(
					Arrays.toString(song.twoSum(new int[]
					{3, 2, 3}, 6)));
		int i = 2;
		i = i++ + i++ + i++;

	}
}

