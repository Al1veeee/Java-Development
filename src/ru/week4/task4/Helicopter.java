package ru.week4.task4;

public class Helicopter extends Vehicle implements FlyCapable {

    public Helicopter(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public void start() {
        System.out.println("Вертолет заведён");
    }

    @Override
    public void stop() {
        System.out.println("Вертолёт заглушен");
    }

    @Override
    public double getMaxSpeed() {
        return 300;
    }

    @Override
    public void takeOff() {
        System.out.println("Вертолет взлетает");
    }

    @Override
    public void land() {
        System.out.println("Вертолёт приземляется");
    }
}
