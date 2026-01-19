package ru.week1.day1;

public class MonthlySalary {
    public static void main(String[] args) {
        int hourlyRate = 15; //Евро в час
        int hoursPerWeek = 40; //Часов в неделю
        int MoneyPerMonth = hourlyRate * hoursPerWeek * 4;
        int MoneyPerYear = MoneyPerMonth * 12;
        if (MoneyPerMonth == 2400) {
            System.out.println("Заработная плата составляет: " + MoneyPerMonth);
        } else {
            System.out.println("Заработная плата должна составлять: 2400");
        }
        System.out.println("Годичная зарплата составляет: " + MoneyPerYear);

    }
}
