package ru.week4.task3;

public class Main {

    public static void distributeMonthlyBonus(Bonusable[] employees, double bonus) {
        for (Bonusable emp : employees) {
            emp.giveBonus(bonus);
        }
    }

    public static void main(String[] args) {

        /* 1 задание
        Manager manager = new Manager("Иван", "М001", 50000, 5);
        Developer developer = new Developer("Петр", "D001", 40000, "Java", 3, 3);

        System.out.println(manager.displayRole());
        System.out.println("Зарплата: " + manager.calculateSalary());

        System.out.println(developer.displayRole());
        System.out.println("Зарплата: " + developer.calculateSalary());
         */

        /*

        Employee[] employees = {
                new Manager("Иван", "M001", 50000, 5),
                new Developer("Петр", "D001", 40000, "Java", 3, 3),
                new Developer("Мария", "D002", 40000, "Python", 2, 4),
                new Intern("Алекс", "I001", 15000, "МГУ")
        };

        //1. Максимальное значение
        double max1 = 0;
        for (Employee emp: employees) {
            if (emp.baseSalary > max1) {
                max1 = emp.baseSalary;
            }
        }
        System.out.println("Максимальная зарплата: " + max1);

        //2. Среднее значение
        double max2 = 0;
        for (Employee emp: employees) {
            max2 += emp.baseSalary;
        }
        System.out.println("Среднее значение: " + max2 / employees.length);

        //3. Общий фонд оплаты
        System.out.println("Общий фонд оплаты: " + max2);

         */

        Manager m = new Manager("Иван", "M1", 100_000, 5);
        Developer d = new Developer("Анна", "D1", 120_000, "Python", 4, 4);
        Intern i = new Intern("Пётр", "I1", 40_000, "MIREA");

        Bonusable[] list = { m, d, i};
        distributeMonthlyBonus(list, 10_000);

        System.out.println("Manager salary = " + m.getSalary());
        System.out.println("Developer salary = " + d.getSalary());
        System.out.println("Intern salary = " + i.getSalary());

    }
}
