package ru.week3.day6.SystemOfManagementStudents;

public class Student {
    private int id;
    private String name;
    private String email;
    private int age;

    public Student(int id, String name, String email, int age) {
        setId(id);
        setName(name);
        setEmail(email);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id должен быть > 0"); // валидация через исключение допустима [web:1]
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name не должен быть пустым"); // валидация через исключение [web:1]
        }
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("email не должен быть пустым"); // валидация через исключение [web:1]
        }
        String normalized = email.trim();
        // простая проверка формата (не RFC, но для учебного проекта достаточно)
        if (!normalized.contains("@") || normalized.startsWith("@") || normalized.endsWith("@")) {
            throw new IllegalArgumentException("email должен содержать '@' и быть корректным");
        }
        this.email = normalized;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age >= 120) {
            throw new IllegalArgumentException("age должен быть в диапазоне 0..119"); // пример валидации возраста [web:8]
        }
        this.age = age;
    }

    public void displayInfo() {
        System.out.printf("Student{id=%d, name='%s', email='%s', age=%d}%n", id, name, email, age);
    }
}
