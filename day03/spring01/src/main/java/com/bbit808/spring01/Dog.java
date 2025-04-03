package com.bbit808.spring01;

// interface는 implements 키워드를 사용해야 함 !!
public class Dog implements Animal {
    private String name;
    private int age;
   
    // 생성자
    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override // 부모 클래스로부터 상속을 받은 메서드를 재정의하는 것!!
    public void cry() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'cry'");
        System.out.println(this.age + "살 " + this.name + "이(가) 짖습니다. 멍! 멍! ");
    }

    @Override
    public void introduce() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'introduce'");
        System.out.println("안녕하세요 ! 저는 " + this.name + " 강아지예요 !");
    }
    
}
