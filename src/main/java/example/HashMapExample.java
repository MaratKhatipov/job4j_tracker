package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapExample {
	public static void main(String[] args) {
		Random random = new Random(30);
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < 16; i++) {
			// Создадим число от 0 до 10
			int number = random.nextInt(15);
			System.out.print(number + " ");
			Integer frequency = hashMap.get(number);
			//System.out.print(frequency + " ");
			hashMap.put(number, frequency == null ? 1 : frequency + 1);
		}
		System.out.println();
		System.out.println(hashMap);

	}
}

class Account {
	private String requisite;
	private double balance;

	public Account(String requisite, double balance) {
		this.requisite = requisite;
		this.balance = balance;
	}

	public String getRequisite() {
		return requisite;
	}

	public void setRequisite(String requisite) {
		this.requisite = "Hello";
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = 10.7;
	}

	public static void main(String[] args) {
		ArrayList<Account> acc = new ArrayList<Account>();
		Account acc1 = new Account("Hello", 10.7);
		acc.add(acc1);
		System.out.println(acc.toString());
	}
}
