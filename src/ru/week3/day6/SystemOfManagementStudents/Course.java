package ru.week3.day6.SystemOfManagementStudents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private String instructor;
    private final List<Student> students = new ArrayList<>();

    public Course(String courseName, String courseCode, String instructor) {
        setCourseName(courseName);
        setCourseCode(courseCode);
        setInstructor(instructor);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("courseName не должен быть пустым"); // валидация через исключение [web:1]
        }
        this.courseName = courseName.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("courseCode не должен быть пустым"); // валидация через исключение [web:1]
        }
        this.courseCode = courseCode.trim();
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        if (instructor == null || instructor.trim().isEmpty()) {
            throw new IllegalArgumentException("instructor не должен быть пустым"); // валидация через исключение [web:1]
        }
        this.instructor = instructor.trim();
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student не должен быть null"); // валидация через исключение [web:1]
        }

        // .stream Превращает в поток
        // .anyMatch возвращает true если хотя бы 1 элемент удовлетворяет условию
        // (s -> s.getId() == student.getId()) - лямба выражение где id элемента списка сравнивается с id студента
        boolean exists = students.stream().anyMatch(s -> s.getId() == student.getId());
        if (exists) {
            throw new IllegalArgumentException("Студент с id=" + student.getId() + " уже добавлен в курс");
        }
        students.add(student);
    }

    public boolean removeStudent(int studentId) {
        // removeIf — удобный способ удаления по условию (Java 8+) [web:6]
        return students.removeIf(s -> s.getId() == studentId); // removeIf удаляет элементы, подходящие под условие [web:12]
    }

    public int getStudentCount() {
        return students.size();
    }

    public void displayAllStudents() {
        System.out.println("Студенты курса " + courseCode + " (" + courseName + "):");
        if (students.isEmpty()) {
            System.out.println("  (пока нет студентов)");
            return;
        }
        for (Student s : students) {
            System.out.print("  ");
            s.displayInfo();
        }
    }

    public void displayCourseInfo() {
        System.out.printf("Course{courseName='%s', courseCode='%s', instructor='%s', students=%d}%n",
                courseName, courseCode, instructor, getStudentCount());
    }
}
