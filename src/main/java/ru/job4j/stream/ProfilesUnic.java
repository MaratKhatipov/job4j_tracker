package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProfilesUnic {
	public static List<AddressUnic> collect(List<ProfileUnic> profile) {
		return profile.stream()
				.map(ProfileUnic::getAddress)
				.collect(Collectors.toList());
	}

	public static List<AddressUnic> sortedCol(List<ProfileUnic> profiles) {
		return profiles.stream()
				.map(ProfileUnic::getAddress)
				.sorted(Comparator.comparing(AddressUnic::getCity))
				.distinct()
				.collect(Collectors.toList());
	}

}


