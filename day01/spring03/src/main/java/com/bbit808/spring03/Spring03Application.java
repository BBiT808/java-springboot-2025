package com.bbit808.spring03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring03Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring03Application.class, args);

		// for문 연습
		String names[] = {"홍길동", "이순신", "강감찬", "유관순", "안중근"};

		int sum = 0;
		// 1부터 10까지 1씩 증가하면서 반복
		for (int i = 1; i <= 10; i++) {
			sum += 1;
		}
		System.out.println("1에서 10까지 합은 " + sum + "입니다.");

		// 배열, 컬렉션을 반복 첫번째 방법
		for (int i=0; i<5; i++) {
			System.out.println(names[i]);
		}
		System.out.println();

		// 두번째 방법
		for (String name : names) {
			System.out.println(name);
		}
	
	}

}
