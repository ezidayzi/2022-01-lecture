package com.ezidayzi;

public class Dog extends Animal {
    Dog() {
        this.name = "강아지";
    }

    @Override
    void sing() {
        System.out.println("멍멍멍");
    }

    @Override
    void move() {
        System.out.println("와다다");
    }
}
