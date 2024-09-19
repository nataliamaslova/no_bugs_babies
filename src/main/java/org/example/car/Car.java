package org.example.car;

public class Car implements Drivable {
    private String brand;
    private String model;
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("engine on");
    }

    @Override
    public void stop() {
        System.out.println("engine off");
    }

    @Override
    public void distance(int s) {
        System.out.println("Path: " + s);
    }
}
