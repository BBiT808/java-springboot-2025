package com.bbit808.spring05;

public class Dog extends Animal {
    
    // 부모 메서드 오버라이딩
    void cry() {
        System.out.println(super.name + "이(가) 웁니다. 멍멍 !!");
    }
    
    void run() {
        System.out.println(this.name + "이 달립니다.");
    }
    
}
