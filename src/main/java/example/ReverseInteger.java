package example;

public class ReverseInteger {
	public  int reverse(int x) {
		long reversedData = 0;
		int tmp = x;
		while (tmp > 0 || tmp < 0) {
			reversedData = reversedData * 10 + tmp % 10;
			tmp = tmp / 10;
			if (reversedData > 2147483647 || reversedData < -2147483648) {
				return 0;
			}
		}
		return (int) reversedData;
	}

	public static void main(String[] args) {
		ReverseInteger rev = new ReverseInteger();
		int result = rev.reverse(-214748364);
		System.out.println(result);
	}
}
