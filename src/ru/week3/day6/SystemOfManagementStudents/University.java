package ru.week3.day6.SystemOfManagementStudents;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("course не должен быть null"); // валидация через исключение [web:1]
        }
        boolean exists = courses.stream().anyMatch(c -> c.getCourseCode().equalsIgnoreCase(course.getCourseCode()));
        if (exists) {
            throw new IllegalArgumentException("Курс с кодом " + course.getCourseCode() + " уже существует");
        }
        courses.add(course);
    }

    public Course findCourse(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("courseCode не должен быть пустым"); // валидация через исключение [web:1]
        }
        String code = courseCode.trim();
        return courses.stream()
                .filter(c -> c.getCourseCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public void displayAllCourses() {
        System.out.println("Курсы университета:");
        if (courses.isEmpty()) {
            System.out.println("  (курсов нет)");
            return;
        }
        for (Course c : courses) {
            System.out.print("  ");
            c.displayCourseInfo();
        }
    }

    public int getTotalStudentCount() {
        return courses.stream().mapToInt(Course::getStudentCount).sum();
    }
}
