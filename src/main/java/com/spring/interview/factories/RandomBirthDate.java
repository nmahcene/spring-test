package com.spring.interview.factories;

import java.time.LocalDate;
import java.util.Random;


/**
 * 
 * @author n_mah
 * Birth Date Generator
 */

public class RandomBirthDate {

	/**
	 * 
	 * @return birthDate randomly
	 */
	public static LocalDate getBirthDay() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		return randomBirthDate;
	}
}
