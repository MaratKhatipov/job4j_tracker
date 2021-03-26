package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
	private Map<String, Citizen> citizens = new HashMap<>();

	public Map<String, Citizen> getCitizens() {
		return citizens;
	}

	public boolean add(Citizen citizen) {
		citizens.size();
		boolean result = false;
		if (!citizens.containsKey(citizen.getPassport())) {
			citizens.put(citizen.getPassport(), citizen);
			result = true;
			citizens.size();
		}
		return result;
	}

	public Citizen get(String passport) {
		return citizens.get(passport);
	}
}
