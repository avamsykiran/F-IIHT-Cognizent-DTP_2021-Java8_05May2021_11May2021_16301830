package com.cts.jdk8.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimePackageDemoApp {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		LocalDate indianIndependenceDate = LocalDate.of(1947, Month.AUGUST,15);
		
		System.out.println(today);
		System.out.println(indianIndependenceDate);
		
		LocalDateTime delhiTime = LocalDateTime.now();
		ZonedDateTime canadaTime = ZonedDateTime.now(ZoneId.of("GMT-4"));
		System.out.println(delhiTime);
		System.out.println(canadaTime);
		
		LocalDate dob = LocalDate.of(1985, Month.JUNE, 11);
		LocalDate dor = dob.plusYears(60);
		System.out.println(dob);
		System.out.println(dor);
		
		Period age = Period.between(dob, today);
		System.out.println(age);
		System.out.println(age.toTotalMonths()/12.0);
		
		DateTimeFormatter frmtr = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(today.format(frmtr));
		System.out.println(dob.format(frmtr));
		
		//LocalDate doj = LocalDate.parse("2021-01-23");
		LocalDate doj = LocalDate.parse("Oct 07,2000",DateTimeFormatter.ofPattern("MMM dd,yyyy"));
		System.out.println(doj.format(frmtr));
	}
}
