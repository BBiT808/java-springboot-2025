package com.bbit808.spring02;

public class Storage<P>{
    private P item;
    // 소문자 p는 잘 안 쓴대~ 대문자 P 사용 !!

    
    public P getItem() {
        return item;
    }
    public void setItem(P item) {
        this.item = item;
    }
    
}
