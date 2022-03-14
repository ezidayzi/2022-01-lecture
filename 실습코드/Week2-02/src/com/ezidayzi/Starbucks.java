package com.ezidayzi;

// 자식 클래스

public class Starbucks extends Cafe {
    Starbucks () {
        this.cafeName = "스타벅스";
        this.mainMenu = "돌체 라떼";
        this.price = 5000;
        // this.menuCount = 3; private 이므로 접근 불가
    }

    @Override
    public void makeCoffee() {
        System.out.println("스타벅스에 오신것을 환영합니다.");
        super.makeCoffee();
    }
}
