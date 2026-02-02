package ru.week3.day6.SystemOfManagementStudents;

public class Main {
    public static void main(String[] args) {
        // Создаём студентов
        Student s1 = new Student(1, "Иван Петров", "ivan.petrov@mail.com", 19);
        Student s2 = new Student(2, "Мария Соколова", "maria.sokolova@mail.com", 20);
        Student s3 = new Student(3, "Алексей Смирнов", "alex.smirnov@mail.com", 18);

        // Создаём курсы
        Course javaCore = new Course("Java Core", "JAVA-101", "Dr. Brown");
        Course databases = new Course("Databases", "DB-201", "Prof. Stone");

        // Добавляем студентов в курсы
        javaCore.addStudent(s1);
        javaCore.addStudent(s2);

        databases.addStudent(s2);
        databases.addStudent(s3);

        // Университет
        University uni = new University();
        uni.addCourse(javaCore);
        uni.addCourse(databases);

        // Вывод информации
        uni.displayAllCourses();
        System.out.println();

        javaCore.displayCourseInfo();
        javaCore.displayAllStudents();
        System.out.println();

        databases.displayCourseInfo();
        databases.displayAllStudents();
        System.out.println();

        System.out.println("Общее количество студентов во всех курсах: " + uni.getTotalStudentCount());
    }
}

