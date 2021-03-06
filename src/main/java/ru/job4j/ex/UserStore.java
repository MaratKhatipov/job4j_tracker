package ru.job4j.ex;

public class UserStore {
	public static User findUser(User[] users, String login) throws UserNotFoundException {
		User result = null;
		for (User user : users) {
			if (user.getUsername().equals(login)) {
				result = user;
				break;
			}
		}
		if (result == null) {
			throw new UserNotFoundException("User not found");
		}
		return result;
	}

	public static boolean validate(User user) throws UserInvalidException {
		if (user.getUsername().length() < 3 || !user.isValid()) {
			throw new UserInvalidException("User name less than 3 or User invalid");
		}
		return user.isValid();
	}

	public static void main(String[] args) {
		User[] users = {
				new User("Petr Arsentev", true)
		};
		try {
			User user = findUser(users, "Petr Arsentev");
			if (validate(user)) {
				System.out.println("This user has an access");
			}
		} catch (UserInvalidException e) {
			e.printStackTrace();
		} catch (UserNotFoundException unfe) {
			unfe.printStackTrace();
		}
	}
}

