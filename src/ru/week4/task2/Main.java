package ru.week4.task2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Красный", 5),
                new Rentangle("Синий", 4, 6),
                new Triangle("Зеленый", 3, 4, 5),
                new Square("Желтый", 5)
        };


        double TotalArea = 0;
        Shape maxAreaShape = shapes[0];
        for (Shape shape: shapes) {
            TotalArea += shape.getArea();
            if (shape.getArea() > maxAreaShape.getArea()) {
                maxAreaShape = shape;
            }
        }

        Shape maxAreaPerimeter = shapes[0];

        for (Shape shape: shapes) {
            if (shape.getPerimeter() > maxAreaPerimeter.getPerimeter()) {
                maxAreaPerimeter = shape;
            }
        }
        System.out.println("Общая площадь: " + TotalArea);
        System.out.println("Максимальная площадь: " + maxAreaShape.getArea());
        System.out.println("Максимальный периметр: " + maxAreaPerimeter.getArea());

    }
}

