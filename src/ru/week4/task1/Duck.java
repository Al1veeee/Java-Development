package ru.week4.task1;

public class Duck extends Bird implements Swimmable, Playable {
    String waterType;

    public Duck(String name, int age, double wingspan, String waterType) {
        super(name, age, wingspan);
    }

    @Override
    public void play() {
        System.out.println("Утка плывет");
    }

    @Override
    public void swim() {
        System.out.println("Утка играет в воде");
    }

    public void quack() {
        System.out.println("Кря-кря!");
    }
}
