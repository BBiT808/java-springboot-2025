## Java 기초문법 

#### 20250401 첫 시작~
### 기본
- 소스 코드 구조(템플릿)

    ```java
    // 한줄 주석
    /* 여러줄 
        주석 */
    package com.bbit808.spring01; // 자기 프로젝트의 패키지명(폴더)

    import org.springframework.boot.SpringApplication; // 라이브러리, 클래스 가져오기
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication // 자바 프로젝트 실행을 도와주는 어노테이션
    public class Spring01Application { // 자기 클래스 명

        // 엔트리 포인트(프로젝트당 하나만 존재)
	    public static void main(String[] args) { // 함스, 클래스, 조건문, 반복문 시작이 중괄호({})
		    SpringApplication.run(Spring01Application.class, args); // 한 줄이 끝나면 반드시 ;(세미콜론)

		    System.out.println("Hello, Spring Boot!"); // 콘솔 출력, 문자열을 항상 "(쌍따옴표 ; 홑따옴표는 쓰면 안 돼!!!)
    	}

    }
    ```

- 자바 특징
    - `간결`하면서 강력한 객체지향 언어 ; 다른 컴퓨터 언어에 비해서(Python 제외)
    - `플랫폼 독립적`, OS에 영향을 거의 받지 않음
    - 라이브러리가 아주 다양, `생산성` 향상
    - GUI 프로그램 개발에는 부적합 ; 안드로이드는 바뀐 Java임 !! ; (Swing, JavaFX로 가능)
    - 정밀하게 Hw를 제어하는 프로그램에도 부적합

- `JVM` 위에서 동작
    - Java Virtual Machine : 도커 컨테이너와 비슷한 개념
    - sourcecode.java -> javac(Java compiler) -> bytecode.class -> java로 실행

- 활용 분야
    - 웹에 특화, 인터넷 포털, 인터넷 뱅킹 , 쇼핑몰, 기업시스템
    - 안드로이드 개발 언어였음. Kotlin(자바에서)으로 변경

### 기초문법

#### 변수
- 변수 선언방법

    ```java
    [접근제어자] 타입 변수명;

    ```
    - 접근 제어자 - 변수의 접근범위를 지정하는 키워드(public, default, protected, private)
    - 타입 - 자료형. 자바는 명시적으로 타입 지정해야함
    - 변수명 - 일반적인 변수명 지정법과 동일

    ```java
    int account = 10000000;                 //  정수형(Primitive type) ; 원시자료형
    private String sayhi = "Hello!"         //  문자열형(Class type)  ; 객체자료형    
    MyClass inst = new MyClass();           //  사용자정의 클래스형 ; new를 쓰는 것은 Java C+ C++의 특징 ! (Python은 안 씀!)
    ```

- 변수 종류
    - 지역변수, 매개변수, 멤버변수, 인스턴스 변수, 


#### 자료형
- 원시자료형(Primitive type)

    |구분|자료형|크기|설명| 
    |:---:|:---:|:---:|:---:|
    |정수형|byte| 1byte, -128~127    |가장 작은 단위, 8bit  |
    |      |char| 2bytes, 0~65535|unsigned자료형, 문자표현용     |
    |      |short|2bytes, -32768~32767 |signed자료형, 작은 데이터 처리용   |
    |      |int|4bytes(32bit 컴퓨터와의 호완성 문제), -2147백만 ~ 2147백만| 기본자료형  |
    |      |long|8bytes, -922경~922경 |큰정수자료형   |
    |실수형|float| 4bytes, 1.4E-45~3.40E38 | 실수형, 숫자 뒤에 f 사용 필수   |
    |      |double| 8bytes, 4.8E-324~1.79E308| 실수형기본자료형   |
    |논리형|boolean|1byte, true 또는 false    |논리형, 참/거짓 표현용   |

    ```java
    int number;
    char ch_first = 'a';
    long longnum = 23456789L;
    float fnum = 3.141592F;
    boolean isTrue = false;
    ```

#### 연산자 
- 연산자는 거의 대부분의 언어에서 동일하게 사용
    - 사칙연산 : +, -, *, /, %
    - 대입연산 : =, +=, -=, *=, /=, %=, ++(a ++, a = a+1 동일), --
    - 비트연산 : &, |, ^, ~, >>, <<
    - 논리연산 : &&, ||, !
    - 관계연산 : ==, >, >=, <, <=, !=

#### 흐름제어
- 조건문(분기문) : if문, switch문
    - if문

    ```java
    if (조건식) {
        // if문 안으로 들어와서
        실행코드 블럭;
    } else if (조건식) {
        실행코드 블럭;
    } else {
        //어디에도 참이 되지 않으면...
        실행코드 블럭;
    }
    ``` 

    - switch문 - 조건값에 따라 여러 분기로 나눌 때 좋음. if문으로 대체 가능

    ```java
    switch (입력변수) {
        case 조건값1:
            실행코드 블럭;
            break;
        case 조건값2:
            실행코드 블럭;
        case 조건값3:
            실행코드 블럭;
            break; // 조건값2에서 시작하면 조건값3까지 모두 수행
        default:
            기본실행코드 블럭;
            break; // case나 default에 되도록이면 빼지 말 것.
    }
    ```
    - 3항 연산 - 간단하게 구현할 조건문 if-else 대신 사용. 실행코드 블럭이 한 줄 일 때.
    
    ```java
    String result = (isLogin) ? "로그인 성공 !" : "로그인 실패 .." ; // 훨씬 효율적임 !

    if (isLogin) {
        result = "로그인 성공 !";
    } else {
        result = "로그인 실패 ..";
    }
    ```

- 반복문 : for문, while문, do-while문

    - for문 - 대표적인 반복문

    ```java
    for (초기값; 조건식; 증감식) {
        실행코드 블럭;
    }

    // 배열, 컬렉션을 처리하는 반복문
    for (변수 : 컬렉션데이터) {
        실행코드 블럭;
    }
    ```

    - while문 ; 조건식이 참인 동안 계속 반복
    ```java
    while (참조건식) {
        실행코드 블럭;
    }
    ```

    - do-while문 ; 우선 실행코드를 한 번 수행 후 조건을 검사 후 반복

    ```java
    do {
        실행코드 블럭;
    } while(조건식);

    ```

- 반복 제어 키워드 : break, continue
    - for문, while문 내에서 사용
    - break : 조건에 맞을 경우 반복문을 탈출
    - continue : 특수 조건만 비켜서 반복문을 계속할 때 ; 반복문을 계속 수행 !!

##### 20250402 Java/Spring boot 두 번째 수업 !!
#### 배열
- 여러 데이터가 필요할 경우 하나의 변수로 처리 가능
- 여러 개의 데이터를 순차적으로 저장할 때 인덱스가 0부터 시작
- 데이터를 순차적으로 접근하기 때문에 위치를 모르면 효율이 좋지 않음
- Java의 배열은 모두 동일한 자료형이여야 함
- 중간의 데이터를 추가하거나 삭제하려면 기존 데이터를 모두 이동해야 함

    ```java
    타입 변수명[] = {데이터 배열값, ...}; // 데이터 개수에 따라 배열 사이즈가 결정
    타입[] 변수명 = {데이터 배열값, ...};
    타입[] 변수명 = new 타입[5]; // 아무값 없이 초기화

    변수명[1]; // 배열 1번 인덱스에 위치
    변수명[1] = 값; // 값을 할당
    System.out.println(변수명[1]); // 값을 사용 !!
    ```

- 배열에 사용할 매서드
    - sort() : 배열 정렬
    - toString() : 배열 객체 ID를 출력
    - asList() : 배열을 리스트로 변경(!)
    - copyOf() : 배열을 복사해서 새로운 배열로 반환
    - equals() : 두 개 배열이 동일한 지 여부 판별
    - binarySearch() : 배열 내 요소를 찾아서 인덱스를 반환

- Java 컬렉션 프레임워크 ; 배열을 좀더 기능적으로 강화한 객체
    - List, Stack, Vector, **ArrayList**, HashSet, HashMap(파이썬 딕셔너리), HashTable
