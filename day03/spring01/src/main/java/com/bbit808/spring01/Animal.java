package com.bbit808.spring01;

public interface Animal {
    public String name = "이름";
    public int age =1 ;

    void cry(); // 추상메서드. 내부구현이 없음.

    // 메서드 구현이 들어갈 수 있음 !! 예외적인 사용.
    public default void introduce() {
        System.out.println("안녕하세요 ! 제 이름은 " + this.name + "입니다.");
    }


}
