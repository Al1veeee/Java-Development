package ru.week4.task2;

public class Triangle extends Shape {

    private double sideA, sideB, sideC;
    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideC;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC)/2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
    @Override
    public double getPerimeter() {
        return (sideA + sideB + sideC);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
