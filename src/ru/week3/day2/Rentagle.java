package ru.week3.day2;

public class Rentagle {
    int width;
    int height;

    public Rentagle(int width, int height) { // Конструктор
        this.width = width; // Привязка параметра width к полю width
        this.height = height; // Привязка параметра height к полю height
    }

    public int getArea() {
        return width * height;
    }
    public int getPerimeter() {
        return (2 * (width + height));
    }

    public static void main(String[] args) {
        Rentagle rect = new Rentagle(5, 10);
        System.out.println(rect.getArea());      // Output: 50
        System.out.println(rect.getPerimeter()); // Output: 30
    }
}
