package com.valtech.training.new12;

import java.time.LocalDate;
import java.util.Date;
//not sql.DATE

public class DataSample {

	public static void main(String[] args) {
		// index year = 1900
//		        month = 0
//		        date = 1

		Date date = new Date(47, 7, 15);
		System.out.println(date);

		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independenceDay);
	}

	
}
