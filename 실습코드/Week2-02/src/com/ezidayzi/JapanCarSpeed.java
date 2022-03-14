package com.ezidayzi;

public class JapanCarSpeed implements CarSpeed {
    private static final int MAX_SPEED = 130;

    @Override
    public int speed(int speed) {
        return Math.min(speed, MAX_SPEED);
    }
}
