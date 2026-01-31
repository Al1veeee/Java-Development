package ru.week3.day3;

public class Person {

    private String name;
    private int age;
    private String email;

    public Person(String Name, int Age, String Email) {
        this.name = Name;
        this.age = Age;
        this.email = Email;
    }
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Некорректное значение");
        }
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Некорректное значение");
        }
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Некорректное значение, нужен @");
        }
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 25, "alice@example.com");

        person.setAge(30);
        person.setAge(200);
        person.setEmail("invalid-email");

        System.out.println(person.age);


    }
}
