package ru.week4.task3;

public class Intern extends Employee {
    private String university;

    public Intern(String name, String id, double baseSalary, String university) {
        super(name, id, baseSalary);
        this.university = university;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public String displayRole() {
        return "Стажер из " + university;
    }

    @Override
    public void giveBonus(double amount) {
        salary += amount * 1;
    }
}
