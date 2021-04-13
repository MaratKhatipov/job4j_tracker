package example;

public class RandomDream {
	public static String random(String[] prizes, int num) {
		int massLength = prizes.length;
		int tmp = num % massLength;
		String result = null;
		for (int index = 0; index < massLength; index++) {
			if (tmp > 0) {
				result = prizes[tmp - 1];
				break;
			} else {
				result = prizes[massLength - 1];
			}
		}
		return result;
	}
}
