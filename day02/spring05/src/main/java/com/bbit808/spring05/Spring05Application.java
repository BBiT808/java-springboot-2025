package com.bbit808.spring05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring05Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring05Application.class, args);

		// 상속
		Dog ppoppy = new Dog();
		ppoppy.setName("뽀삐");
		ppoppy.cry();
		//ppoppy.age = 8; // -19 ; 이런건 말이 안 돼 !!
		ppoppy.setAge(450);
		System.out.println("뽀삐의 나이는 "+ ppoppy.getAge() + "살");

		Cat kitty = new Cat();
		kitty.setName("키티");
		kitty.cry();
		//kitty.age = 3;
		ppoppy.setAge(12);
		System.out.println("뽀삐의 나이는 " + ppoppy.getAge() + "살");

		// 20250403 추가!!
		Dog choonsam = new Dog();
		choonsam.setName("춘삼"); // 부모클래스에서 private로 선언된 name을 자식클래스에서 접근할 수 없다.
		choonsam.cry();
		System.out.println(choonsam.getClass().toString()); // Objerct 클래스의 메서드를 사용할 수 있다!!
	}

}
