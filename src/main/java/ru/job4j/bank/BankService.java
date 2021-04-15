package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель банковской системы.
 * В системе можно производить следующие действия.
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author MARAT KHATIPOV
 * @version 1.0
 */
public class BankService {
	/**
	 * Это поле содержит всех пользователей системы с привязанными к ним счетами
	 */
	private Map<User, List<Account>> users = new HashMap<>();

	/**
	 * Метод добавления пользователя в систему
	 * @param user пользователь, которого добавляем в систему
	 * В методе должна быть проверка, что такого пользователя еще нет в системе.
	 * Если он есть, то нового добавлять не надо
	 */
	public void addUser(User user) {
		users.putIfAbsent(user, new ArrayList<>());
	}

	/**
	 * Метод добавления нового счёта пользователю
	 * @param passport производим поиск по паспорту
	 * @param account счёт который добавляем, должна быть проверка,
	 * что такого счета у пользователя еще нет
	 */
	public void addAccount(String passport, Account account) {
		Optional<User> user = findByPassport(passport);
		if (user.isPresent()) {
			List<Account> userAcc = users.get(user.get());
			if (!userAcc.contains(account)) {
				userAcc.add(account);
			}
		}
	}

	/**
	 * Метод поиска пользователя по паспорту
	 * @param passport паспорт, который ищём
	 * @return возвращаем номер паспорта, если нашли
	 */

	public Optional<User> findByPassport(String passport) {
		return users.keySet()
				.stream()
				.filter(u -> u.getPassport().equals(passport))
				.findFirst();
	}
	/**
	 * Метод поиска счёта по пользователя по реквизитам
	 * @param passport номер паспорта для поиска
	 * @param requisite реквизиты для поиска
	 * @return возвращаем счёт пользователя
	 */

	public Optional<Account> findByRequisite(String passport, String requisite) {
		Optional<User> user = findByPassport(passport);
		if (user.isPresent()) {
			return users.get(user.get())
					.stream()
					.filter(u -> u.getRequisite().equals(requisite)).
					findFirst();
		}
		return Optional.empty();
	}

	/**
	 * Метод для перечисления денег с одного счёта на другой счёт
	 * @param srcPassport паспорт пользователя, со счёта которого осуществляется перевод
	 * @param srcRequisite реквизиты счёта, с которого осуществляется перевод
	 * @param destPassport паспорт пользователя, на чей счёт переводим
	 * @param destRequisite реквизиты счёта, куда переводим
	 * @param amount сумма перевода
	 * @return возвращаем true если счёт найден и хватает денег на счёте (srcAccount),
	 * иначе возвращаем false
	 */

	public  boolean transferMoney(String srcPassport, String srcRequisite,
			String destPassport, String destRequisite, double amount) {
		boolean result = false;
		Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
		Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
		if (
				srcAcc.isPresent() && destAcc.isPresent()
				&& srcAcc.get().getBalance() >= amount
		) {
			srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
			destAcc.get().setBalance(destAcc.get().getBalance() + amount);
			result = true;
		}
		return result;
	}
}
