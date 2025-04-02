package com.bbit808;

public class car {
    public String name;
    public int year;
    private String company; // 클래스 외부에서 사용 불가 !!
    
    public void printCarName() {
        System.out.println("차 이름은  " + name);
    }
    
    
    // 매서드 오버로딩 !!
    public void printCarName(String point ) {
        System.out.println("차 이름은 " + name + "포인트는");
    }
    
    // 가변 인자
    public void printCarName(String... name) {
        for (String n : name) {
            System.out.println(n);
            }
        }
    
    int calcYear(int currYear) {
        return currYear - year;
    }

    public static void printYear(){
        // System.out.println("year"); 출력 안 됨 !!
        System.out.println("2020년");
    }
    
}
