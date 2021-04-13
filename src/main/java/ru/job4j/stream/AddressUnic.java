package ru.job4j.stream;

import java.util.Objects;

public class AddressUnic {
	private String city;
	private String street;
	private int homeNumber;
	private int apartment;

	public AddressUnic(String city, String street, int homeNumber, int apartment) {
		this.city = city;
		this.street = street;
		this.homeNumber = homeNumber;
		this.apartment = apartment;
	}

	public String getCity() {
		return city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AddressUnic addressUnic = (AddressUnic) o;
		return homeNumber == addressUnic.homeNumber
				&& apartment == addressUnic.apartment
				&& city.equals(addressUnic.city)
				&& street.equals(addressUnic.street);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street, homeNumber, apartment);
	}

	@Override
	public String toString() {
		return "AddressUnic{"
				+ "city='" + city + '\''
				+ ", street='" + street + '\''
				+ ", homeNumber=" + homeNumber
				+ ", apartment=" + apartment
				+ '}';
	}
}
