package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
	private Map<User, List<Account>> users = new HashMap<>();

	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<>());
	}

	public void addAccount(String passport, Account account) {
		User user = findByPassport(passport);
		if (user != null) {
			List<Account> userAcc = users.get(user);
			if (!userAcc.contains(account)) {
				userAcc.add(account);
			}
		}
	}

	public User findByPassport(String passport) {
		for (User index : users.keySet()) {
			if (index.getPassport().equals(passport)) {
				return index;
			}
		}
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
		return result;
	}
}
