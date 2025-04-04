package com.bbit808.spring03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring03Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring03Application.class, args);


		// 컬렉션 프레임워크
		//List
		List<String> lst1 = new ArrayList<>();

		lst1.add("One");
		lst1.add("Two");
		lst1.add("Three");
		lst1.add("Four");

		System.out.println(lst1);

		List<String> lst2 = new ArrayList<>();
		lst2.add("Five");
		lst2.add("Six");

		lst1.addAll(lst2); // 다른 리스트 추가
		lst1.set(0, "Zero"); // 인덱스 0에 있는 요소를 "Zero"로 변경
		
		System.out.println(lst1);
		System.out.println(lst1.get(5)); // Six

		// 연결리스트
		List<Integer> lst3 = new LinkedList<>();
		lst3.add(10);
		lst3.add(20);
		lst3.add(30);
		System.out.println(lst3);

		// 정렬
		Collections.sort(lst1);
		System.out.println(lst1);

		Collections.sort(lst1, Collections.reverseOrder());
		System.out.println(lst1);
		// lst1.sort(); // 이 정렬 메서드 사용해도 무방 !!

		System.out.println(lst1.contains("Three")); // "Three"가 리스트에 있는지 확인
		System.out.println(lst1.isEmpty()); // 리스트가 비어있는지 판별
		System.out.println(lst1.size()); // 배열 .length() 동일
		lst1.remove(5);

		// 중요한 메서드 !!
		// lst1.clear(); // 함부로 쓰지 말 것 ! 프로그램 종료 시 리스트를 비우자 !!!

		// Vector
		Vector<String> vec1 = new Vector<>(10);  // 용량을 지정할 수 있음
		vec1.add("One");
		vec1.add("Three");
		System.out.println("벡터 크기 ! : " + vec1.size());
		System.out.println("벡터 용량 ! : " + vec1.capacity());


		// Set
		Set<String> set1 = new HashSet<>();
		set1.add("One");
		set1.add("Two");
		set1.add("Three");
		set1.add("Four");
		set1.add("One"); // 중복된 값은 추가되지 않음

		System.out.println(set1);

		System.out.println(set1.contains("Three")); // lst1 리스트에 "Three"라는 문자열이 존재하는지 여부
		System.out.println(set1.isEmpty()); // 리스트가 비어있는지 판별
		System.out.println(set1.size()); // 배열 .length() 동일
		set1.remove("Four"); // set은 순서가 없기 때문에 지울 요소값을 입력해야 함 !!
		set1.removeAll(set1); // 모두 지운다 
		// set1.clear();
		set1.add("Five");
		System.out.println(set1);

		// Map
		Map<String, String> phones = new HashMap<>();
		phones.put("010-1234-5678", "Galaxy S10");
		phones.put("010-2345-6789", "IPhone 14");
		phones.put("010-3456-7890", "Galaxy S24");
		phones.put("010-4567-8901", "IPhone 15");

		System.out.println(phones);

		System.out.println(phones.get("010-1234-5678")); // key와 매칭되는 Value가 출력 !!
		System.out.println(phones.values()); // 모든 Value값을 출력
		System.out.println(phones.keySet()); // 모든 Key값을 출력
		System.out.println(phones.containsKey(phones.get("010-1234-5678"))); // Key값이 존재하는지 확인
		System.out.println(phones.containsValue("Galaxy S10")); // Value값이 존재하는지 확인

		// 샘플 - 학생 네명의 국어, 영어, 수학, 미술, 체육 점수 합산/평균
		List<Integer> std1 = Arrays.asList(96,100,55,80,70);
		List<Integer> std2 = Arrays.asList(100,100,99,95,96);
		List<Integer> std3 = Arrays.asList(50,50,40,100,90);
		List<Integer> std4 = Arrays.asList(85,85,84,86,80);

		Map<String, List<Integer>> students = new HashMap<>();
		students.put("홍길동", std1);
		students.put("애슐리", std2);
		students.put("성유고", std3);
		students.put("기윤기윤", std4);

		Scanner scan = new Scanner(System.in);
		System.out.println(" # 성적을 조회할 학생 이름을 입력하세요 : ");
		String inName = scan.next();
		
		int sum = 0;
		for (int score : students.get(inName)) { // "홍길동" -> [96, 100, 55, 80, 70]
			sum += score;
		}
		
		System.out.println(inName + "학생의 성적 총점은 " + sum + "점 입니다." + "\n평균은 " + (sum /5) + "점 입니다.");


	}

}