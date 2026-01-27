package ru.week3.day1;

public class Car {
    private String brand;
    private String color;
    private int year;
    private int speed;

    public Car (String brand, String color, int year, int speed){
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.speed = speed;
        speed = 0;
    }
    public void accelerate() {
        speed += 10;
        System.out.println("Speed: " + speed);
    }
    public void brake() {
        speed -= 10;
        System.out.println("Speed: " + speed);
    }
    public void getInfo() {
        System.out.println("Марка машины: " + brand + ", Цвет: " + color + ", Год выпуска: " + year + ", Скорость: " + speed);
    }
}
class Rain {
    public static void main(String[] args) {
        Car car = new Car("BMW", "red", 2015, 200);
        car.getInfo();
        car.brake();
        car.getInfo();

    }
}
