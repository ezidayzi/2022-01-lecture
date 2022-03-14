package com.ezidayzi;

public class Duck extends Animal{
    Duck() {
        this.name = "오리";
    }

    @Override
    void sing() {
        System.out.println("꽥꽥꽥");
    }

    @Override
    void move() {
        System.out.println("뒤뚱뒤뚱");
    }
}
