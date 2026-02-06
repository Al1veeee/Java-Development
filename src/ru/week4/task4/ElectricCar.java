package ru.week4.task4;

public class ElectricCar extends Car implements Chargeable {
    private int BatteryPercent;

    public ElectricCar(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year, numberOfDoors);
    }

    @Override
    public void charge() {
        BatteryPercent = 100;
    }

    @Override
    public int getBatteryPercent() {
        return BatteryPercent;
    }

    @Override
    public double getMaxSpeed() {
        return maxSpeed = 200;
    }
}
