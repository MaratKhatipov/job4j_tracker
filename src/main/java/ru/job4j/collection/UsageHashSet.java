package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
	public static void main(String[] args) {
		HashSet<String> autos = new HashSet<>(); // Lada, BMW, Volvo, Toyota.
		autos.add("Lada Sedan");
		autos.add("BMW");
		autos.add("Volvo");
		autos.add("Toyota");
		for (String auto : autos
			 ) {
			System.out.println(auto);
		}
	}
}
