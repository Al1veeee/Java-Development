package ru.week5.day2;

import java.util.LinkedList;
import java.util.Queue;

public class Task3 {

    LinkedList<Integer> intList = new LinkedList<>();

    public void addFirstEnd(Integer first, Integer end) {
        intList.addFirst(first);
        intList.addLast(end);
    }

    public void removeFirstEnd(Integer first, Integer end) {
        intList.removeFirst();
        intList.removeLast();
    }

    public void add(Integer first) {
        intList.addFirst(first);
    }

    public void displayInfo() {
        System.out.print("Вывод обычного листа: ");
        for (Integer s : intList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    Queue<Integer> Qlist = new LinkedList<>(intList);

    public void updateQlist() {
        Qlist = new LinkedList<>(intList);
    }

    public void poll() {
        System.out.println("\nПервым вышел: " + Qlist.poll());
    }

    public void fifoInfo() {
        System.out.print("Вывод FIFO листа: ");
        for (Integer s : Qlist) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();

        task3.add(1);
        task3.add(2);
        task3.add(6);
        task3.addFirstEnd(3,5);
        task3.displayInfo();

        task3.updateQlist();
        task3.fifoInfo();

        task3.poll();
        task3.fifoInfo();

        task3.poll();
        task3.fifoInfo();
    }
}
