package com.ezidayzi;

public class Cafe {
    public String cafeName;
    protected String mainMenu;
    protected Integer price;
    private Integer menuCount;

    public void makeCoffee() {
        System.out.println(cafeName+"에서 판매하는 "+mainMenu+"은/는 "+ price+"원 입니다.");
    }
}
