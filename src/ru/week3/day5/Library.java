package ru.week3.day5;

import java.util.ArrayList;

public class Library {
    private ArrayList<String> books = new ArrayList<>();
    private String author;
    private String tittle;
    private int year;

    public void addBook(String book) {
        if (!book.isEmpty()) {
            books.add(book);
        }
    }
    public void removeBook(String tittle) {
        for (String book : books) {
            if (tittle.equals(book)) {
                books.remove(book);
            } else {
                System.out.println("Такой книги не найдено!");
            }
        }
    }
    public void findBook(String tittle) {
        for (String book : books) {
            int i = 1;
            if (tittle.equals(book)) {
                System.out.println("\nЭта книга находится под номером: " + i++);
            } else {
                System.out.println("\nТакой книги нету в списке!");
            }
        }
    }
    public String getTotalBooks() {
        int i=1;
        System.out.print("Список книг: ");
        for (String book : books) {
            System.out.print("\n" + i++ + ". " + book);
        }
        return "";
    }

    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Крутой1");
        library.getTotalBooks();
        library.findBook("Крутой1");
    }
}
