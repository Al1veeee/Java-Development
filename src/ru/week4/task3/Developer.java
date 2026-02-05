package ru.week4.task3;

public class Developer extends Employee {
    private String programmingLanguage;
    private int yearsOfExperience;
    private int teamSize;

    public Developer(String name, String id, double baseSalary, String programmingLanguage, int yearsOfExperience, int teamSize) {
        super(name, id, baseSalary);
        this.programmingLanguage = programmingLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (500 * yearsOfExperience);
    }

    @Override
    public String displayRole() {
        return String.format("Менеджер с командой из %d человек", teamSize);
    }

    @Override
    public void giveBonus(double amount) {
        salary += amount * 1.10;
    }
}
