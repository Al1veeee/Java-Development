package ru.week4.task2;

public class Rentangle extends Shape {
    private double width, height;

    public Rentangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width * height);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
