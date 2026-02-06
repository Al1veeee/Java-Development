package ru.week4.task4;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Машина заводится");
    }

    @Override
    public void stop() {
        System.out.println("Машина останавливается");
    }

    @Override
    public double getMaxSpeed() {
        return maxSpeed = 180;
    }
}
