package ru.week3.day1;

public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public void getInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Почта: " + email);
    }
    public void haveBirthday() {
        age++;
        System.out.println("Исполняется " + age + " лет");
    }
}
class Main {
    public static void main(String[] args) {
        Person person = new Person("Дени", 18, "alidenchik@mail.ru");
        person.getInfo();
        person.haveBirthday();
        person.getInfo();
    }
}
