package ru.week5.day1;

import java.util.HashMap;
import java.util.Map;


public class Task1 {

    HashMap<String, String> phoneBook = new HashMap<>();

    public void getNumber(String name) {
        if (phoneBook.containsKey(name)) {
            String phone = phoneBook.get(name);
            System.out.println("Номер " + name + ": " + phone);
        } else {
            System.out.println("Такого номера в книге нет");
        }
    }

    public void addNumber(String name, String number) {
        phoneBook.put(name, number);
    }

    public void displayInfo() {
        for (Map.Entry<String, String> entry: phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void removeNumber(String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Контакт удален");
        }
    }

    public void amount() {
        System.out.println("Всего контактов: " + phoneBook.size());
    }

    public void clear() {
        phoneBook.clear();
    }

    public static void main(String[] args) {
        Task1 phoneBook1 = new Task1();

        phoneBook1.addNumber("Лариса", "89966906795");
        phoneBook1.addNumber("Иван", "+7-123-456-78-90");
        phoneBook1.addNumber("Мария", "+7-987-654-32-10");

        phoneBook1.displayInfo();
        phoneBook1.getNumber("Иван");

        phoneBook1.clear();

        phoneBook1.displayInfo();
    }
}
