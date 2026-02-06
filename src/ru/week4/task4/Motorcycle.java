package ru.week4.task4;

public class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String brand, String model, int year, boolean hasSideCar) {
        super(brand, model, year);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void start() {
        System.out.println("Мотоцикл заведён!");
    }

    @Override
    public void stop() {
        System.out.println("Мотоцикл остановлен");
    }

    @Override
    public double getMaxSpeed() {
        return maxSpeed = 220;
    }
}
