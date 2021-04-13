package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesUnicTest {

	@Test
	public void collect() {
		AddressUnic addrFirst = new AddressUnic("Yekaterinburg", "Baumana", 15, 100);
		AddressUnic addrSecond = new AddressUnic("Leningrad", "NevskProsp", 66, 56);
		AddressUnic addrThird = new AddressUnic("Tagiiil", "Pivnaya", 50, 15);

		ProfileUnic profile1 = new ProfileUnic(addrFirst);
		ProfileUnic profile2 = new ProfileUnic(addrSecond);
		ProfileUnic profile3 = new ProfileUnic(addrThird);

		List<ProfileUnic> profiles = Arrays.asList(profile1, profile2, profile3);
		List<AddressUnic> expect = Arrays.asList(addrFirst, addrSecond, addrThird);
		assertThat(ProfilesUnic.collect(profiles), is(expect));
	}

	@Test
	public void sortedCol() {
		AddressUnic addr1 = new AddressUnic("Yekaterinburg", "Baumana", 15, 100);
		AddressUnic addr2 = new AddressUnic("Leningrad", "NevskProsp", 66, 56);
		AddressUnic addr3 = new AddressUnic("Tagiiil", "Pivnaya", 50, 15);
		AddressUnic addr4 = new AddressUnic("Moscow", "Arbat", 150, 125);
		AddressUnic addr5 = new AddressUnic("Tagiiil", "Pivnaya", 50, 15);
		AddressUnic addr6 = new AddressUnic("Leningrad", "NevskProsp", 6, 56);
		AddressUnic addr7 = new AddressUnic("Leningrad", "NevskProsp", 66, 6);
		AddressUnic addr8 = new AddressUnic("Leningrad", "NevskProsp", 66, 56);

		ProfileUnic profile1 = new ProfileUnic(addr1);
		ProfileUnic profile2 = new ProfileUnic(addr2);
		ProfileUnic profile3 = new ProfileUnic(addr3);
		ProfileUnic profile4 = new ProfileUnic(addr4);
		ProfileUnic profile5 = new ProfileUnic(addr5);
		ProfileUnic profile6 = new ProfileUnic(addr6);
		ProfileUnic profile7 = new ProfileUnic(addr7);
		ProfileUnic profile8 = new ProfileUnic(addr8);

		List<ProfileUnic> profiles = Arrays.asList(
				profile1, profile2, profile3, profile4,
				profile5, profile6, profile7, profile8);

		List<AddressUnic> expect = Arrays.asList(
				addr2, addr6, addr7,
				addr4, addr5, addr1
		);
		assertThat(ProfilesUnic.sortedCol(profiles), is(expect));
	}
}