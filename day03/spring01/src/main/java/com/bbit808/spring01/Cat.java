package com.bbit808.spring01;

public class Cat implements Animal {
    private String name;
    private int age;

    // 생성자
    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override // 부모 클래스로부터 상속을 받은 메서드를 재정의하는 것!!
    public void cry() {
    // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'cry'");
    System.out.println(this.age + "살 " + this.name + " 이(가) 웁니다. 야~옹 !!");
    }

    @Override
    public void introduce() {
        System.out.println("안녕하세요 ! 제 이름은 " + this.name + " 고양이예요 !");

   
    }
}
    
