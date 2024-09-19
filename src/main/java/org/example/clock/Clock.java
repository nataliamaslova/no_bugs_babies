package org.example.clock;

public class Clock implements Readable {
    private int hour;
    private int minute;
    private int second;

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void tick() {
        second++;
    }

    @Override
    public void readTime() {
        System.out.println(hour + ":" + minute + ":" + second);
    }
}
