package ru.week3.day2;

public class Circle {
    double radius;
    double PI = 3.14;

    public Circle(double radius) { // Конструктор
        this.radius = radius; // Привязка параметра radius к полю radius
    }

    public double getArea() {
        return (PI * (radius*radius));
    }
    public double getCircumference() {
        return (2 * PI * radius);
    }

    public static void main(String[] args) {
        Circle circ = new Circle(5);

        System.out.println(circ.getArea());
        System.out.println(circ.getCircumference());
    }
}
