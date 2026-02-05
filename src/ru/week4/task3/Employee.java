package ru.week4.task3;

public abstract class Employee implements Bonusable {
    protected String name;
    protected String id;
    protected double baseSalary;
    protected double salary;  // поле каждого объекта

    public Employee(String name, String id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.salary = baseSalary;
    }

    public double getSalary() {  // УБРАЛ static! Теперь работает для объекта
        return salary;
    }

    public abstract double calculateSalary();
    public abstract String displayRole();
}

