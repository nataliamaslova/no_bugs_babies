package org.example.point;

public class Main {
    public static void main(String[] args) {
        Point point= new Point();
        point.setX(3);
        point.setY(8);
        System.out.println("x: " + point.getX() + ", y: " + point.getY());
        point.moveRight();
        point.moveUp();
        System.out.println("x: " + point.getX() + ", y: " + point.getY());
    }
}
