package ru.week5.day2;

import java.util.ArrayList;

public class Task2 {
    public static class Student {
        private String name;
        private String id;
        private int mark;


        public Student(String name, String id, int mark) {
            this.name = name;
            this.id = id;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getMark() {
            return mark;
        }
    }

    public static class Group {

        private ArrayList<Student> students = new ArrayList<>();

        public void add(String name, String id, int mark) {
            students.add(new Student(name, id, mark));
        }

        public void findName(String name) {
            boolean found = false;
            for (Student s : students) {
                if (s.getName().equals(name)) {
                    System.out.println("Имя: " + name + " найдено!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Имя не найдено!");
            }
        }

        public void displayInfo() {
            for (Student s : students) {
                System.out.println(s.getName() + " | " + s.getId() + " | " + s.getMark());
            }
        }

        public void goodStudents() {
            for (Student s : students) {
                if (s.getMark() > 80) {
                    System.out.println(s.getName() + " | " + s.getId() + " | " + s.getMark());
                }
            }
        }

        public void bigStudent() {
            String name = "";
            String id = "";
            int mark = 0;
            int max = 0;
            for (Student s : students) {
                if (s.getMark() > max) {
                    max = s.getMark();
                    name = s.getName();
                    id = s.getId();
                    mark = max;
                }
            }
            System.out.println("Самый лучший ученик: " + name + " | " + id + " | " + mark);
        }


        //Среднее между первой и последней
        public void averageMark() {
            int max = 0;
            int min = 100;
            for (Student s : students) {
                if (s.getMark() > max) {
                    max = s.getMark();
                }
            }
            for (Student k : students) {
                if (k.getMark() < min) {
                    min = k.getMark();
                }
            }
            double average = (min + max)/2;
            System.out.println("Среднее между первым и последним: " + average);
        }

        //Общее среднее значение
        public void averageMarkAll() {
            double sum = 0;
            for (Student s : students) {
                sum += s.getMark();
            }
            double result = sum / students.size();
            System.out.println("Общее среднее: " + result);
        }
    }

    public static void main(String[] args) {
        Group group = new Group();  // Создаём группу

        group.add("Иван", "001", 85);
        group.add("Петр", "002", 72);
        group.add("Дени", "003", 100);

        group.displayInfo();

        group.findName("Дени");
        group.averageMark();
        group.averageMarkAll();

        group.goodStudents();
        group.bigStudent();

    }

}
