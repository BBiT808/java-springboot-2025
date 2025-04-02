package com.bbit808.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		// 배열
		int[] score = {90, 98, 100, 76, 83};
		System.out.println(score.length);

		score[4] =85; // 4번째 인덱스 값을 83 > 85로 변경 !

		System.out.println(score); // 배열 변수를 출력한다고 값을 표시하지 않음

		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}

		// 두 번째 배열
		String[] carcompany = {"Hyundai", "Kia", "Ssangyong", "Toyota", "Benz", "BMW", "Tesla"};
	}

}
