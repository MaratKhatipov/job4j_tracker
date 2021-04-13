package example;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String result = "";
		int count = 0;
		char[][] arrayLetters = new char[strs.length][];
		for (int index = 0; index < strs.length; index++) {
				arrayLetters[index] = strs[index].toCharArray();
			System.out.println(arrayLetters[index]);
		}
		for (int i = 1; i < arrayLetters.length - 1; i++) {
			for (int j = 0; j < arrayLetters[i].length; j++) {
				if (arrayLetters[i][j] == arrayLetters[i - 1][j]
						&& arrayLetters[i][j] == arrayLetters[i + 1][j]
				) {
					count++;
					char[] res = new char[count];
					arrayLetters[i][j] = res[count - 1];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LongestCommonPrefix pref = new LongestCommonPrefix();
		System.out.println(
				pref.longestCommonPrefix(new String[]
						{"flower", "flow", "flight"}
				)
		);

	}
}
