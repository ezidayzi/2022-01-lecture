package com.ezidayzi;

public class KoreaCarSpeed implements CarSpeed {
    private static final int MAX_SPEED = 100;

    @Override
    public int speed(int speed) {
        return Math.min(speed, MAX_SPEED);
    }
}
