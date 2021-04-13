package example;

public class Palindrome {
	public boolean isPalindrome(int x) {
		long tmpValue = x;
		long reverseValue = 0;
		while (tmpValue > 0) {
			reverseValue = reverseValue * 10 + tmpValue % 10;
			tmpValue = tmpValue / 10;
		}
		return reverseValue == (long) x;
	}

	public static void main(String[] args) {
		Palindrome poly = new Palindrome();
		System.out.println(poly.isPalindrome(2147483647));
	}
}
