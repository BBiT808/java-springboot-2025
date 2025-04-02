package com.bbit808.spring05;

public class Cat extends Animal {
    // 자식클래스 고양이
    void cry() {
        System.out.println(super.name + "이(가) 웁니다. 야옹 !!");
    }
    
    void run() {
        System.out.println(this.name + "이 달립니다.");
    }
    
}
