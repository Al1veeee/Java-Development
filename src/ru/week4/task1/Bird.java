package ru.week4.task1;

public class Bird extends Animal {

    private double wingspan;

    public Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }

    @Override
    public void makeSound() {
        System.out.println("Чирик");
    }

    public void fly() {
        System.out.println("Птица летит на высоте");
    }
}
