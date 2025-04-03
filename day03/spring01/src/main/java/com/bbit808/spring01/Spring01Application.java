package com.bbit808.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);

		// 20250403 식목일 !!!!! 그리고 3번째 수업 !!!!
		// 인터페이스 연습 !!
		Dog ppoppy = new Dog("뽀삐", 12);
		Cat kitty = new Cat("키티", 8);
		// ppoppy.name ="뽀삐";
		// ppoppy.age = 12;  > 이렇게 못 씀 !!

		ppoppy.introduce();
		ppoppy.cry();

		kitty.introduce();
		kitty.cry();

		// 인터페이스는 특이하게 사용하는 경우가 있음 !!
		// 변수를 선언할 때 상위 인터페이스인 Animal을 사용하면
		// 클래스를 변경해도 문제가 발생하지 않음 !
		// 스프링의 의존성 주입(Dependency Injection)에 핵심이 됨 !!
		Animal choonsam = new Dog("춘삼", 10);
		// Cat choonsam = new Dog는 안 돼 !!!!
		// 근데 Animal choonsam = new Dog는 가능하대 !! ; 인터페이스할 때 !!
		choonsam.introduce();
		choonsam.cry();
	}
}
