package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

	@Test
	public void addUser() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		assertThat(bank.findByPassport("3434"), is(Optional.of(user)));
	}

	@Test
	public void addSameUser() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addUser(user);
		assertThat(bank.findByPassport("3434"), is(Optional.of(user)));
	}

	@Test
	public void whenEnterInvalidPassport() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
	}

	@Test
	public void addAccount() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
	}

	@Test
	public void addSameAccounts() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("1111", 150D));
		bank.addAccount(user.getPassport(), new Account("1111", 150D));
		assertThat(bank.findByRequisite("3434", "1111").get().getBalance(), is(150D));
	}

	@Test
	public void add2Accounts() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("1111", 150D));
		bank.addAccount(user.getPassport(), new Account("1122", 300D));
		assertThat(bank.findByRequisite("3434", "1122").get().getBalance(), is(300D));
	}

	@Test
	public void transferMoney() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		bank.addAccount(user.getPassport(), new Account("113", 50D));
		bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
		assertThat(
				bank.findByRequisite(user.getPassport(), "113")
						.get().getBalance(), is(200D));
	}

	@Test
	public void transferMoneyFirsAcc() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 150D));
		bank.addAccount(user.getPassport(), new Account("113", 50D));
		bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
		assertThat(
				bank.findByRequisite(user.getPassport(), "5546")
						.get().getBalance(), is(0D));
	}

	@Test
	public void transferMoneyFalse() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("5546", 50D));
		bank.addAccount(user.getPassport(), new Account("113", 150D));
		boolean chek = bank.transferMoney(
				user.getPassport(), "5546", user.getPassport(),
				"113", 150D
		);
		assertThat(false, is(chek));
	}

	@Test
	public void transferMoneyFalse2() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("6546", 350D));
		bank.addAccount(user.getPassport(), new Account("113", 150D));
		boolean chek = bank.transferMoney(
				user.getPassport(), "5546", user.getPassport(),
				"113", 150D
		);
		assertThat(false, is(chek));
	}

	@Test
	public void transferMoneyFalse3() {
		User user = new User("3434", "Petr Arsentev");
		BankService bank = new BankService();
		bank.addUser(user);
		bank.addAccount(user.getPassport(), new Account("6546", 350D));
		bank.addAccount(user.getPassport(), new Account("113", 350D));
		boolean chek = bank.transferMoney(
				user.getPassport(), "5546", user.getPassport(),
				null, 150D
		);
		assertThat(false, is(chek));
	}
}