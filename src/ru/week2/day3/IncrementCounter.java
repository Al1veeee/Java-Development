package ru.week2.day3;

public class IncrementCounter {
    static int increment = 0;

    public static void incrementCounter() {
        increment++;
    }
    public static void getCounter() {
        System.out.println(increment);
    }

    public static void main(String[] args) {
        getCounter();
        incrementCounter();
        getCounter();
    }
}
