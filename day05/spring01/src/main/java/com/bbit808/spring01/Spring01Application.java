package com.bbit808.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 20250407 5번째 Java 수업 !!!!!!!!!!! 갸악 Java란 뭘까 ..
@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);

		// StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("Hello ");
		sb.append("Java !");

		System.out.println(sb.toString());
		System.out.println(sb); // StringBuilder 객체만으로도 출력

		StringBuilder sb2 = new StringBuilder("Hi ");
		sb2.append("Beautiful day !");
		System.out.println(sb2.toString());

		// 리스트처럼 중간에 내용을 삽입 가능
		sb2.insert(3, "How are you today ? ");
		System.out.println(sb2.toString());
		
		// 문자열 길이
		System.out.println(sb.length());
		
		// 문자열 삭제
		sb2.delete(22, 39); // 지울 시작인덱스, 마지막 인덱스
		System.out.println(sb2.toString());

		// 인덱스 위치 문자 하나 삭제 !
		sb2.deleteCharAt(0); // 0번째 인덱스 문자 삭제
		System.out.println(sb2.toString());

		// 문자열을 거꾸로 출력(해서 리턴까지!)
		System.out.println(sb2.reverse());
		sb2.reverse(); // 원래대로 돌리기

		// 문자열 대체
		sb2.replace(0, 1, "hi");
		System.out.println(sb2.toString());

		// 문자열 자르기, 자른 값을 다른 변수에 할당해야 함 !! ㅇ0ㅇ
		System.out.println(sb2.substring(9).toString());
			// StringBuilder는 toString()을 호출하지 않으면 자른 값이 안나옴 !!!!
		System.out.println(sb2.toString());

		StringBuilder sb3 = new StringBuilder("    Hello    ");
		System.out.println(sb3);
		  // cf) 여백 제거
		System.out.println(sb3.toString().trim()); // StringBuilder는 trim()이 없대 !!!!

		// StringBuffer
		StringBuffer sf = new StringBuffer();
		sf.append("Hollay, Java !");
		sf.insert(6, " C# and");
		System.out.println(sf); 
	}

}
