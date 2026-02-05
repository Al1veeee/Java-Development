package ru.week4.task3;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, String id, double baseSalary, int teamSize) {
        super(name, id, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (100 * teamSize);
    }

    @Override
    public String displayRole() {
        return String.format("Менеджер с командой из %d человек", teamSize);
    }

    @Override
    public void giveBonus(double amount) {
        salary += amount * 1.20;
    }
}
