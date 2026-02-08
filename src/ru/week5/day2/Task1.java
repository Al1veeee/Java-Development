package ru.week5.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task1 {

    ArrayList<String> cities = new ArrayList<>();

    private void add(String name) {
        cities.add(name);
    }

    public void lastend() {
        System.out.println(cities.get(0));
        System.out.println(cities.get(2));
    }

    public void deleteIndex(int index) {
        cities.remove(index);
    }

    public void findCity(String city) {
        if (cities.contains(city)) {
            System.out.println("Город: " + city + "\nЕсть в списке! :)");
        } else {
            System.out.println("Города: " + city + "\nНет в списке! :(");
        }
    }

    public void sort() {
        Collections.sort(cities);
    }

    public void displayInfo() {
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
    }

    public static void main(String[] args) {
        Task1 task = new Task1();

        task.add("Мурманск");
        task.add("Москва");
        task.add("Питер");
        task.add("Дубай");
        task.add("Шарджа");

        task.deleteIndex(0);
        task.sort();
        task.displayInfo();
        task.findCity("Питер");

    }

}
