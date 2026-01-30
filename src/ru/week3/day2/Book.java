package ru.week3.day2;

public class Book {
    String author;
    String tittle;
    int year;

    public Book(String author, String tittle, int year) {
        this.author = author;
        this.tittle = tittle;
        this.year = year;
    }
    void displayInfo() {
        System.out.println("Автор: " + author + " Название: " + tittle + " Год: " + year);
    }

    public static void main(String[] args) {
        Book book = new Book("War and Peace", "Leo Tolstoy", 1869);
        book.displayInfo();
    }
}
