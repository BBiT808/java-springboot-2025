package com.bbit808.spring01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);


		// 20250404 Java 벌써!!!!!!! 4번째수업!!!!!!!!!!! 크아아아악
		// 날짜 타입
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);

		LocalDate date2 = LocalDate.of(2017, 7, 9);
		System.out.println(date2); // 2025-04-04

		// Date format
		String date3 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(date3);

		System.out.println(LocalDate.now().getYear());
		System.out.println(LocalDate.now().getMonth());
		System.out.println(LocalDate.now().getMonthValue());
		System.out.println(LocalDate.now().getDayOfMonth());
		System.out.println(LocalDate.now().getDayOfWeek());
		System.out.println(LocalDate.now().getDayOfYear());

		// 날짜 차이
		// cf) .해서 바로 쓰면 static함수 !!!
		System.out.println(LocalDate.now().plusDays(2));
		System.out.println(LocalTime.now().minusHours(2));
	}

}
