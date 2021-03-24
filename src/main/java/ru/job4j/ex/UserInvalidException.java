package ru.job4j.ex;

import ru.job4j.ex.UserNotFoundException;

public class UserInvalidException extends UserNotFoundException {
	public UserInvalidException(String msg) {
		super(msg);
	}
}
