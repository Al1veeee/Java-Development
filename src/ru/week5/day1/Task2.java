package ru.week5.day1;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    class Contact {
        private String name;
        private String phone;
        private String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

    // Геттеры
        public String getName() { return name; }
        public String getPhone() { return phone; }
        public String getEmail() { return email; }

        @Override
        public String toString() {
            return name + " | " + phone + " | " + email;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        
    }



    HashMap<String, Contact> contacts = new HashMap<>();

    {
        contacts.put("Иван", new Contact("Иван", "123-45-67", "ivan@mail.ru"));
        contacts.put("Мария", new Contact("Мария", "987-65-43", "maria@mail.ru"));
        contacts.put("Петр", new Contact("Петр", "555-66-77", "petr@mail.ru"));

    }

    public void searchName(String name) {
        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            System.out.println("Найден контакт: " + contact);
        }
    }

    // 3 Stream API

    public List<String> getEmails() {
        return contacts.values().stream()
                .map(Contact::getEmail)
                .collect(Collectors.toList());
    }

    public List<String> getSortedNames() {
        return contacts.values().stream()
                .map(Contact::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public void displayEmailInfo() {
        contacts.values().stream()
                .filter(c -> c.getEmail().endsWith("@gmail.com"))
                .forEach(System.out::println);
    }

    public void findShortNumber() {
        Contact shortestPhone = contacts.values().stream()
                .min((c1, c2) -> c1.getPhone().length() - c2.getPhone().length())
                .orElse(null);
    }

    public boolean hasGmail() {
        return contacts.values().stream()
                .anyMatch(c -> c.getEmail().contains("@gmail.com"));
    }

    public void findNumber(String number) {
        for (Contact contact : contacts.values()) {
            if (contact.getPhone().equals(number)) {
                System.out.println("Найден контакт: " + contact.getName());
            }
        }
    }

    public void sortedInfo() {
        ArrayList<Contact> sortedContacts = new ArrayList<>(contacts.values());
        Collections.sort(sortedContacts, (c1, c2) -> c1.getName().compareTo(c2.getName()));
        for (Contact contact : sortedContacts) {
            System.out.println(contact);
        }
    }

    public void refreshNumber(String name, String number) {
        contacts.get(name).setPhone(number);
    }

    public void findDomen(String mail) {
        for (Contact contact: contacts.values()) {
            if (contact.getEmail().contains(mail)) {
                System.out.println(contact.getName() + " использует: " + mail);
            }
        }
    }

    public static void main(String[] args) {
        Task2 phoneBook = new Task2();  // ✅ Создаем телефонную книгу

        System.out.println("=== 1. Поиск по имени ===");
        phoneBook.searchName("Иван");  // Найден контакт: Иван | 123-45-67 | ivan@mail.ru

        System.out.println("\n=== 2. Stream API ===");
        System.out.println("Все email: " + phoneBook.getEmails());
        // [ivan@mail.ru, maria@mail.ru, petr@mail.ru]

        System.out.println("Отсортированные имена: " + phoneBook.getSortedNames());
        // [Иван, Мария, Петр]

        System.out.println("\n=== 3. Gmail контакты ===");
        phoneBook.displayEmailInfo();  // Ничего (нет @gmail.com)

        System.out.println("\n=== 4. Обновление номера ===");
        phoneBook.refreshNumber("Иван", "999-99-99");
        phoneBook.searchName("Иван");  // Иван | 999-99-99 | ivan@mail.ru

        System.out.println("\n=== 5. Поиск по домену ===");
        phoneBook.findDomen("mail.ru");  // Все найдет

        System.out.println("\n=== 6. Сортировка контактов ===");
        phoneBook.sortedInfo();
    }

}
