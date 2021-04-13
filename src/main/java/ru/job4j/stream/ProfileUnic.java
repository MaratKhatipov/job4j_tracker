package ru.job4j.stream;

public class ProfileUnic {
	private final AddressUnic address;

	public ProfileUnic(AddressUnic address) {
		this.address = address;
	}

	public AddressUnic getAddress() {
		return address;
	}
}
