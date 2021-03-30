package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
	private Map<User, List<Account>> users = new HashMap<>();

	public void addUser(User user) {
		if (!users.containsKey(user)) {
			users.put(user, new ArrayList<Account>());
		} else {
			System.out.println("This user already exists");
		}
	}

	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user == null) {
			System.out.println("Can not find user");
		}
			List<Account> userAcc = users.get(user);
			if (!userAcc.contains(account)) {
				userAcc.add(account);
			} else {
				System.out.println("This user already has such an account.");
			}
	}

	public User findByPassport(String passport) {
		for (User index : users.keySet()) {
			if (index.getPassport().equals(passport)) {
				return index;
			}
		}
		System.out.println("There is NO user with such a passport!");
		return null;
	}

	public  Account findByRequisite(String passport, String requisite) {
		User user = findByPassport(passport);
		if (user != null) {
			List<Account> userAccount = users.get(user);
			for (Account userReq : userAccount) {
				if (userReq.getRequisite().equals(requisite)) {
					return userReq;
				}
			}
		}
		System.out.println("Can not find requisite");
		return null;
	}

	public  boolean transferMoney(String srcPassport, String srcRequisite,
			String destPassport, String destRequisite, double amount) {
		boolean result = false;
		Account srcAcc = findByRequisite(srcPassport, srcRequisite);
		Account destAcc = findByRequisite(destPassport, destRequisite);
		if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
			srcAcc.setBalance(srcAcc.getBalance() - amount);
			destAcc.setBalance(destAcc.getBalance() + amount);
			result = true;
		}
		System.out.println("Chek your balance or account number");
		return result;
	}
}
