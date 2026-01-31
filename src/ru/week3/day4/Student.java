package ru.week3.day4;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private ArrayList<Double> grades = new ArrayList<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void addGrade(double grade) {
        if (grade < 0 || grade > 5) {
            System.out.println("Некорректное значение");
        } else {
            grades.add(grade);
        }
    }

    public double getAverageGrade() {
        double sum = 0.0;

        for (double grad : grades) {
            sum += grad;
        }
        return sum / grades.size();
    }

    public double getHighestGrade() {
        double max = 0;
        for (double grad : grades) {
            if (grad > max) {
                max = grad;
            }
        }
        return max;
    }

    public double getLowestGrade() {
        double min = 10000000;
        for (double grad : grades) {
            if (grad < min) {
                min = grad;
            }
        }
        return min;
    }
    public void showInfo() {
        for (double grad : grades) {
            System.out.println(grad);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("S001", "Alice");

        student.addGrade(4.5);
        student.addGrade(3.8);
        student.addGrade(4.2);

        student.showInfo();

        System.out.println("Средняя оценка: " + student.getAverageGrade());
        System.out.println("Высшая оценка: " + student.getHighestGrade());
        System.out.println("Низшая оценка: " + student.getLowestGrade());
    }
}
