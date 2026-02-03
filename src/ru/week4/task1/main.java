package ru.week4.task1;

public class main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Рекс", 5, "Овчарка"),
                new Cat("Мурка", 3, "чёрная"),
                new Bird("Попугай", 2, 1.5)
        };

        for (Animal animal : animals) {
            animal.makeSound();  // Правильный метод для каждого класса
            animal.eat();
        }

    }
}
