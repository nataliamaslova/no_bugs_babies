package org.example.clock;

public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.setHour(8);
        clock.setMinute(30);
        clock.setSecond(5);
        clock.readTime();
        clock.tick();
        clock.readTime();
    }
}
