package com.ezidayzi.week0401;

public class Greeter {
    private String format;

    private String guest;

//  String 의 문자열 포맷을 이용해서 새로운 문자열 생성
    public String greet(String guest) {
        return String.format(format, guest);
    }

//  greet 메서드에서 사용할 문자열 포맷 설정
    public void setFormat(String format) {
        this.format = format;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

}
