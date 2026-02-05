package ru.week4.task2;

public abstract class Shape implements Comparable {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}