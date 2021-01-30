package ru.job4j.pojo;

import java.util.Date;

public class College {
	public static void main(String[] args) {
		Student freshman = new Student();
		freshman.setName("Wade Winston Wilson");
		freshman.setGroup("X-men trainee ");
		freshman.setReceiptDate(new Date());

		System.out.println(
				"Student name: " + freshman.getName()
				+ System.lineSeparator()
						+ "group: " + freshman.getGroup()
				+ System.lineSeparator()
						+ "Receipt date: " + freshman.getReceiptDate());
	}
}
