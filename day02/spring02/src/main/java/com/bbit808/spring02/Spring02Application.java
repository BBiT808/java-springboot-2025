package com.bbit808.spring02;

//import java.util.Array;
//import java.util.Arrayslist; Ctrl + . 을 누르면 안 쓰는 함수를 지울 수 있다 !!
import java.util.Collections;

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

		for(String car : carcompany) {
			System.out.println(car);
		}

		// 배열의 
		Array<String> car_list = Arrays.asList(carcompany);
		System.out.println(car_list); // 파이썬과 동일
		System.out.println(car_list.get(index:1)); // Kia

		Array.sort(score); // 오름차순 정렬 !!
		for (int item : score) {
			System.out.println(item);
		}

		Arrays.sort(carcompany, Collections.reverseOrder()); // 내림차순 정렬 !!
		for (String car : carcompany) {
			System.out.println(car); // Toyota가 가장 처음 출력 됨 !
		}
	}

}
