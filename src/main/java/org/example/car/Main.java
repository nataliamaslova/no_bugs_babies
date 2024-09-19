package org.example.car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("Nissan");
        car.setModel("X-trail");
        car.setYear(2017);
        car.start();
        car.distance(70);
        car.stop();
    }
}
