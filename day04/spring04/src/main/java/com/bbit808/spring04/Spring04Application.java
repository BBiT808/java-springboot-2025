package com.bbit808.spring04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring04Application {
	//public interface myMax { // 익명함수를 위한 인터페이스
	//int max(int a, int b);}

	public static void main(String[] args) {
		SpringApplication.run(Spring04Application.class, args);

		// 람다식
		//  1. 일반방식
		Spring04Application app = new Spring04Application();
		System.out.println(app.helloJava());

		//  2. 기존익명함수
		//System.out.println(new lambdaFunc()) {public int max(int a, int b) {return a > b ? a : b;}} . max(14, 34);

		//  3. 람다방식 !! (예시) 
		// String result = () -> {"Hello, Java!";};
		//System.out.println({() -> "Hello, Java!"});
		myFuncInterface fi = () -> {System.out.println("Hello, Java! 난 람다람쥐 호출이야 'ㅅ'!"); };
		fi.printHello();

		myCalc calc = (x, y) -> {return x + y; };
		int result = calc.plus(100, 55);
		System.out.println(result);

		// Stream API
		//  1. 기존방식
		  // 단어 위에 빨간줄이 쳐지면 함수가 등록이 되지 않았다는 거임 !!! Ctrl space / Ctrl . / Alt Shift O 눌러보기 !!
		System.out.println("기존방식");
		List<String> avengers = Arrays.asList("IronMan", "Captain America", "Thor", "Hulk", "BlackWidow", "SpiderMan");

		// 정렬
		Collections.sort(avengers);
		System.out.println(avengers);

		for (String hero : avengers) {
			System.out.println(hero);
		}
		// 단점은 출력 시 반복문을 써야하고, 정렬 후 원본의 내용(순서)이 사라짐 !!! ㅇ0ㅇ !!! 허걱!! 

		  // 2. Stream API 사용방식 !
		System.out.println("스트림 API");
		  avengers = Arrays.asList("IronMan", "Captain America", "Thor", "Hulk", "BlackWidow", "SpiderMan");

		  Stream<String> avengersStream = avengers.stream(); // 스트림 생성
		  avengersStream.sorted().forEach(System.out::println); // 정렬 후 출력 ; 원본은 건들지 마 !! -_-^
		  // for문을 안 쓰고 함수 형태로 처리하기 때문에 요새 많이 쓰인다 !!
		  System.out.println(avengers); // 원본이 그대로 유지됨~ ^0^

		  // 스트림 API 실습 !!
		  List<String> originList = Arrays.asList("a1", "c2", "b3", "c1", "a2", "b1");

		    // List<String> copyList = new ArrayList<>(originList.size());
		    //Collections.copy(copyList, originList);
		  List<String> copyList = new ArrayList<>(originList);

		  System.out.println(originList);
		  System.out.println(copyList);

		 // c로 시작하는 요소만 뽑아서 대문자로 변경하고, 정렬해서 개수를 출력하시오. (*_* 점수 없음.)
		  // 기본 방식으로 처리하는 법 !!
		  // 1. 각 요소에서 c로 시작하는 것만 추출 !!
		  List<String> lastList = new ArrayList<>();
		  for (String elmt : copyList) {
			if (elmt.startsWith("c")) {
				lastList.add(elmt);
		  }
		}
		  // 2. 대문자로 변경 !
		  for (int i=0; i < lastList.size(); i++) {
			lastList.set(i, lastList.get(i).toUpperCase());
		  }
		  // 3. 정렬 !
		  Collections.sort(lastList);
		  System.out.println(lastList.size());

		  // 그런데 스트림 API를 사용하면 !! ; 1 줄로 끝 !!!! ^0^
		  System.out.println(originList.stream().filter(s -> s.startsWith("c")) // c로 시작하는 것만 필터링
				  .map(String::toUpperCase) // 대문자로 변경
				  .sorted() // 정렬
				  .toList() // 리스트로 변환
				  .size()); // 개수 세기

		  
	}
	
	// 일반 메서드 호출
	public String helloJava() {
		return "Hello, Java! 난 일반 호출이야 ^_^! ";
	}

	@FunctionalInterface // 함수형 인터페이스로 지칭. 함수형 인터페이스 만들 때 지켜야 할 약속들 체크.
	public interface myFuncInterface {
		void printHello();
	}
	public interface myCalc {
		int plus(int x, int y);
	}

}


