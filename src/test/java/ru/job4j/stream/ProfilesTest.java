package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

	@Test
	public void collect() {
		Address addrFirst = new Address("Yekaterinburg", "Baumana", 15, 100);
		Address addrSecond = new Address("Leningrad", "NevskProsp", 66, 56);
		Address addrThird = new Address("Tagiiil", "Pivnaya", 50, 15);

		Profile profile1 = new Profile(addrFirst);
		Profile profile2 = new Profile(addrSecond);
		Profile profile3 = new Profile(addrThird);

		List<Profile> profiles = Arrays.asList(profile1, profile2, profile3);
		List<Address> expect = Arrays.asList(addrFirst, addrSecond, addrThird);
		assertThat(Profiles.collect(profiles), is(expect));
	}
}