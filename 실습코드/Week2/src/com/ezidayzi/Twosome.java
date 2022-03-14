package com.ezidayzi;

public class Twosome extends Cafe {
    Twosome () {
        this.cafeName = "투썸플레이스";
        this.mainMenu = "스트로베리 초코 생크림 케이크";
        this.price = 6000;
    }

    @Override
    public void makeCoffee() {
        System.out.println("투썸플레이스에 오신것을 환영합니다.");
        super.makeCoffee();
    }
}
