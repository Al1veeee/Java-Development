package ru.week4.task4;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double maxSpeed;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public abstract void start();
    public abstract void stop();
    public abstract double getMaxSpeed();
}
