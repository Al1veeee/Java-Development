package ru.week4.task1;

public class main {
    public static void main(String[] args) {
        Animal duck = new Duck("Дональд", 3, 1.2, "пресная");
        Swimmable swimmingDuck = new Duck("Дональд", 3, 1.2, "пресная");

        duck.makeSound();
        swimmingDuck.swim();

        if (duck instanceof Swimmable) {
            ((Swimmable) duck).swim();  // Утка плывет
        }
    }
}
