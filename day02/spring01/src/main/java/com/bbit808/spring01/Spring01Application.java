package com.bbit808.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);

		//while문 - 조건에 맞지 않으면 한 번도 실행 안 됨 !!
		int num = 10;

		while(num >= 0) {
			System.out.println(num);
			num--; // num을 1씩 감소
		}

		System.out.println("while문 종료 ! ");

		// do-while문 - 조건에 맞지 않아도 한 번은 실행 됨 !! 
		int cnt = 1;
		do {
			System.out.println(cnt);
			cnt++; // cnt를 1씩 증가
			// cnt가 10보다 작을 때까지 반복 !!
		} while (cnt<10);
		
		System.out.println("do-while문 종료 ! ");

		num = 1;
		// break, continue
		while (num < 11) {
			if (num % 2 == 0) {
				num++; // num을 1씩 증가
				break; // ; if문 조건 참이면 반복문을 완전히 빠져나감.. 탈출 !!!!
				//continue; // 짝수는 건너뛰기 ; if문 조건 참이면 빠져나가서 반복문으로 돌아감
			}

			System.out.println(num);
			num++; // num을 1씩 증가
		}

		System.out.println("break/continue 종료 ! ");
	}

}
