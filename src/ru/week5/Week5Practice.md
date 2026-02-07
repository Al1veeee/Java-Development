# 💻 Неделя 5: Коллекции и Структуры Данных - Практические Задачи

## 🎯 Структура практики

Каждая задача имеет три уровня сложности:
- **Уровень 1** — базовая работа с одной коллекцией
- **Уровень 2** — комбинирование коллекций и фильтрация
- **Уровень 3** — Stream API и сложные операции

---

## 📝 Задача 1: Управление Контактами

### Описание
Система для хранения и управления контактами в телефонной книге.

### Уровень 1: Базовые операции с HashMap

```java
import java.util.*;

// Создайте HashMap для хранения контактов
// Ключ: имя (String)
// Значение: номер телефона (String)

HashMap<String, String> phoneBook = new HashMap<>();

// Добавление контактов
phoneBook.put("Иван", "+7-123-456-78-90");
phoneBook.put("Мария", "+7-987-654-32-10");
phoneBook.put("Петр", "+7-555-666-77-88");

// 1. Получить номер Ивана
String ivanPhone = phoneBook.get("Иван");
System.out.println("Телефон Ивана: " + ivanPhone);

// 2. Добавить новый контакт (Анна)
phoneBook.put("Анна", "+7-111-222-33-44");

// 3. Проверить наличие контакта
if (phoneBook.containsKey("Петр")) {
    System.out.println("Петр в книге");
}

// 4. Вывести все контакты (ключи и значения)
for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// 5. Удалить контакт
phoneBook.remove("Петр");

// 6. Количество контактов
System.out.println("Всего контактов: " + phoneBook.size());

// 7. Очистить все
phoneBook.clear();
```

### Уровень 2: Поиск и фильтрация

```java
import java.util.*;

// Создайте более сложную структуру:
// Ключ: имя (String)
// Значение: объект Contact (имя, телефон, email)

class Contact {
    private String name;
    private String phone;
    private String email;
    
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    // Getters...
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

HashMap<String, Contact> contacts = new HashMap<>();

// Добавить контакты
contacts.put("Иван", new Contact("Иван", "123-45-67", "ivan@mail.ru"));
contacts.put("Мария", new Contact("Мария", "987-65-43", "maria@mail.ru"));
contacts.put("Петр", new Contact("Петр", "555-66-77", "petr@mail.ru"));

// 1. Найти контакт по имени
String searchName = "Иван";
if (contacts.containsKey(searchName)) {
    Contact contact = contacts.get(searchName);
    System.out.println("Найден: " + contact);
}

// 2. Найти контакт по телефону (нужен обход)
String searchPhone = "555-66-77";
for (Contact contact : contacts.values()) {
    if (contact.getPhone().equals(searchPhone)) {
        System.out.println("Найден контакт: " + contact.getName());
    }
}

// 3. Вывести всех контактов отсортированные по имени
ArrayList<Contact> sortedContacts = new ArrayList<>(contacts.values());
Collections.sort(sortedContacts, (c1, c2) -> c1.getName().compareTo(c2.getName()));
for (Contact contact : sortedContacts) {
    System.out.println(contact);
}

// 4. Обновить номер телефона
contacts.get("Иван").setPhone("999-88-77");  // Требует setter в Contact

// 5. Найти все контакты содержащие определенный домен (email)
String domain = "mail.ru";
for (Contact contact : contacts.values()) {
    if (contact.getEmail().contains(domain)) {
        System.out.println(contact.getName() + " использует " + domain);
    }
}
```

### Уровень 3: Stream API и сложные операции

```java
import java.util.*;
import java.util.stream.*;

// Используйте Stream API для операций:

// 1. Получить список всех имен (отсортировано)
List<String> names = contacts.values().stream()
    .map(Contact::getName)
    .sorted()
    .collect(Collectors.toList());

// 2. Получить список всех email'ов
List<String> emails = contacts.values().stream()
    .map(Contact::getEmail)
    .collect(Collectors.toList());

// 3. Вывести контакты с email на определенный домен
contacts.values().stream()
    .filter(c -> c.getEmail().endsWith("@gmail.com"))
    .forEach(System.out::println);

// 4. Найти контакт с самым коротким номером телефона
Contact shortestPhone = contacts.values().stream()
    .min((c1, c2) -> c1.getPhone().length() - c2.getPhone().length())
    .orElse(null);

// 5. Проверить наличие контакта с определенным email
boolean hasGmail = contacts.values().stream()
    .anyMatch(c -> c.getEmail().contains("@gmail.com"));
```

---

## 📝 Задача 2: Управление Студентами

### Описание
Система для управления студентами и их оценками.

### Уровень 1: ArrayList базовых операций

```java
import java.util.*;

class Student {
    private String name;
    private int id;
    private double grade;
    
    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    
    public String getName() { return name; }
    public int getId() { return id; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return name + " (ID: " + id + ", Оценка: " + grade + ")";
    }
}

// Создание списка студентов
ArrayList<Student> students = new ArrayList<>();

// Добавление студентов
students.add(new Student("Иван", 1, 85.5));
students.add(new Student("Мария", 2, 92.0));
students.add(new Student("Петр", 3, 78.5));
students.add(new Student("Анна", 4, 88.0));

// 1. Вывести всех студентов
for (Student student : students) {
    System.out.println(student);
}

// 2. Найти студента по имени
String searchName = "Мария";
for (Student student : students) {
    if (student.getName().equals(searchName)) {
        System.out.println("Найден: " + student);
        break;
    }
}

// 3. Найти студента по ID
int searchId = 2;
for (Student student : students) {
    if (student.getId() == searchId) {
        System.out.println("Студент с ID " + searchId + ": " + student);
        break;
    }
}

// 4. Удалить студента по имени
students.removeIf(s -> s.getName().equals("Петр"));

// 5. Вывести студентов с оценкой выше 80
System.out.println("\nСтуденты с оценкой > 80:");
for (Student student : students) {
    if (student.getGrade() > 80) {
        System.out.println(student);
    }
}

// 6. Изменить оценку студента
for (Student student : students) {
    if (student.getName().equals("Иван")) {
        student.setGrade(90.0);
    }
}
```

### Уровень 2: Сортировка и фильтрация

```java
import java.util.*;

// 1. Отсортировать по имени (алфавитно)
ArrayList<Student> sortedByName = new ArrayList<>(students);
Collections.sort(sortedByName, (s1, s2) -> s1.getName().compareTo(s2.getName()));

// 2. Отсортировать по оценке (убывание)
ArrayList<Student> sortedByGrade = new ArrayList<>(students);
Collections.sort(sortedByGrade, (s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));

// 3. Найти студента с максимальной оценкой
Student topStudent = Collections.max(students, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
System.out.println("Лучший студент: " + topStudent);

// 4. Найти студента с минимальной оценкой
Student worstStudent = Collections.min(students, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
System.out.println("Худший студент: " + worstStudent);

// 5. Вычислить среднюю оценку (цикл)
double sum = 0;
for (Student student : students) {
    sum += student.getGrade();
}
double average = sum / students.size();
System.out.println("Средняя оценка: " + average);

// 6. Отфильтровать студентов с оценкой >= 80
ArrayList<Student> excellentStudents = new ArrayList<>();
for (Student student : students) {
    if (student.getGrade() >= 80) {
        excellentStudents.add(student);
    }
}
```

### Уровень 3: Stream API

```java
import java.util.*;
import java.util.stream.*;

// 1. Получить имена всех студентов
List<String> names = students.stream()
    .map(Student::getName)
    .collect(Collectors.toList());

// 2. Вычислить среднюю оценку
double avg = students.stream()
    .mapToDouble(Student::getGrade)
    .average()
    .orElse(0.0);
System.out.println("Средняя оценка: " + avg);

// 3. Найти максимальную и минимальную оценку
double maxGrade = students.stream()
    .mapToDouble(Student::getGrade)
    .max()
    .orElse(0.0);
double minGrade = students.stream()
    .mapToDouble(Student::getGrade)
    .min()
    .orElse(0.0);

// 4. Вывести студентов отсортированных по оценке (убывание)
students.stream()
    .sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
    .forEach(System.out::println);

// 5. Отфильтровать студентов с оценкой >= 85
List<Student> topStudents = students.stream()
    .filter(s -> s.getGrade() >= 85)
    .collect(Collectors.toList());

// 6. Подсчитать студентов с оценкой > 80
long count = students.stream()
    .filter(s -> s.getGrade() > 80)
    .count();
System.out.println("Студентов с оценкой > 80: " + count);

// 7. Получить статистику оценок
IntSummaryStatistics stats = students.stream()
    .mapToInt(s -> (int)s.getGrade())
    .summaryStatistics();
System.out.println("Минимум: " + stats.getMin());
System.out.println("Максимум: " + stats.getMax());
System.out.println("Среднее: " + stats.getAverage());
System.out.println("Сумма: " + stats.getSum());
System.out.println("Количество: " + stats.getCount());

// 8. Сгруппировать студентов по диапазонам оценок
Map<String, List<Student>> groupedByGrade = students.stream()
    .collect(Collectors.groupingBy(s -> {
        if (s.getGrade() >= 90) return "Отличники";
        if (s.getGrade() >= 80) return "Хорошисты";
        return "Удовлетворительно";
    }));
```

---

## 📝 Задача 3: Словарь (Частота Слов)

### Описание
Анализ текста и подсчет частоты слов.

### Уровень 1: HashSet и HashMap

```java
import java.util.*;

String text = "Java Java Python Java C++ Python Java";
String[] words = text.split(" ");

// Вариант 1: HashSet для подсчета уникальных слов
HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
System.out.println("Уникальные слова: " + uniqueWords);
System.out.println("Количество уникальных: " + uniqueWords.size());

// Вариант 2: HashMap для подсчета частоты
HashMap<String, Integer> wordCount = new HashMap<>();

for (String word : words) {
    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}

// Вывести результаты
for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Найти слово с максимальной частотой
String mostFrequent = "";
int maxCount = 0;
for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
    if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostFrequent = entry.getKey();
    }
}
System.out.println("Самое частое слово: " + mostFrequent + " (" + maxCount + " раз)");
```

### Уровень 2: Сортировка результатов

```java
import java.util.*;

// Сортировка HashMap по значению (частоте)
List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

// Сортировать по частоте (убывание)
Collections.sort(sortedWords, (e1, e2) -> e2.getValue() - e1.getValue());

System.out.println("\nСлова отсортированные по частоте:");
for (Map.Entry<String, Integer> entry : sortedWords) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Вывести топ 3 самых частых слова
System.out.println("\nТоп 3 слова:");
for (int i = 0; i < Math.min(3, sortedWords.size()); i++) {
    System.out.println((i+1) + ". " + sortedWords.get(i).getKey() + 
                     ": " + sortedWords.get(i).getValue());
}
```

### Уровень 3: Stream API и анализ текста

```java
import java.util.*;
import java.util.stream.*;

// Анализ текста с использованием Stream API
String text = "Java Java Python Java C++ Python Java C++ Java";
String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");

// 1. Подсчет частоты слов (Stream)
Map<String, Long> frequency = Arrays.stream(words)
    .filter(word -> !word.isEmpty())
    .collect(Collectors.groupingBy(
        word -> word,
        Collectors.counting()
    ));

// 2. Вывести слова отсортированные по частоте
frequency.entrySet().stream()
    .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
    .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

// 3. Найти самое частое слово
Optional<Map.Entry<String, Long>> mostFrequent = frequency.entrySet()
    .stream()
    .max(Map.Entry.comparingByValue());

if (mostFrequent.isPresent()) {
    System.out.println("Самое частое: " + mostFrequent.get().getKey());
}

// 4. Найти все слова с частотой > 2
List<String> frequentWords = frequency.entrySet().stream()
    .filter(e -> e.getValue() > 2)
    .map(Map.Entry::getKey)
    .sorted()
    .collect(Collectors.toList());

// 5. Получить список слов (отсортирован по алфавиту)
List<String> sortedWords = frequency.keySet().stream()
    .sorted()
    .collect(Collectors.toList());
```

---

## 📝 Задача 4: Система Покупок

### Описание
Управление товарами в корзине и расчет итогов.

### Уровень 1: ArrayList товаров

```java
import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return price * quantity; }
    
    @Override
    public String toString() {
        return name + " - " + price + " * " + quantity + " = " + getTotalPrice();
    }
}

// Создание корзины
ArrayList<Product> cart = new ArrayList<>();

// Добавить товары
cart.add(new Product("Яблоко", 50, 3));
cart.add(new Product("Банан", 30, 2));
cart.add(new Product("Апельсин", 60, 1));
cart.add(new Product("Груша", 45, 2));

// 1. Вывести все товары
System.out.println("Корзина:");
for (Product product : cart) {
    System.out.println(product);
}

// 2. Вычислить общую стоимость
double totalPrice = 0;
for (Product product : cart) {
    totalPrice += product.getTotalPrice();
}
System.out.println("Общая стоимость: " + totalPrice);

// 3. Найти самый дорогой товар
Product mostExpensive = cart.get(0);
for (Product product : cart) {
    if (product.getPrice() > mostExpensive.getPrice()) {
        mostExpensive = product;
    }
}
System.out.println("Самый дорогой: " + mostExpensive.getName());

// 4. Вычислить общее количество товаров
int totalQuantity = 0;
for (Product product : cart) {
    totalQuantity += product.getQuantity();
}
System.out.println("Всего товаров: " + totalQuantity);

// 5. Удалить товар
cart.removeIf(p -> p.getName().equals("Банан"));
```

### Уровень 2: Фильтрация и сортировка

```java
import java.util.*;

// 1. Товары дороже определенной цены
double priceFilter = 50;
ArrayList<Product> expensiveProducts = new ArrayList<>();
for (Product product : cart) {
    if (product.getPrice() > priceFilter) {
        expensiveProducts.add(product);
    }
}

// 2. Отсортировать по цене
ArrayList<Product> sortedByPrice = new ArrayList<>(cart);
Collections.sort(sortedByPrice, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

// 3. Отсортировать по названию
ArrayList<Product> sortedByName = new ArrayList<>(cart);
Collections.sort(sortedByName, (p1, p2) -> p1.getName().compareTo(p2.getName()));

// 4. Товар с максимальной стоимостью (price * quantity)
Product maxValue = cart.get(0);
for (Product product : cart) {
    if (product.getTotalPrice() > maxValue.getTotalPrice()) {
        maxValue = product;
    }
}
System.out.println("Товар с максимальной стоимостью: " + maxValue);

// 5. Сколько товаров стоят дешевле 50 рублей?
int cheapCount = 0;
for (Product product : cart) {
    if (product.getPrice() < 50) {
        cheapCount++;
    }
}
```

### Уровень 3: Stream API и статистика

```java
import java.util.*;
import java.util.stream.*;

// 1. Общая стоимость (Stream)
double total = cart.stream()
    .mapToDouble(Product::getTotalPrice)
    .sum();

// 2. Средняя цена товара
double avgPrice = cart.stream()
    .mapToDouble(Product::getPrice)
    .average()
    .orElse(0);

// 3. Товары отсортированные по цене (убывание)
List<Product> sortedByPrice = cart.stream()
    .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
    .collect(Collectors.toList());

// 4. Товары, стоящие дороже средней цены
List<Product> aboveAverage = cart.stream()
    .filter(p -> p.getPrice() > avgPrice)
    .collect(Collectors.toList());

// 5. Получить список названий товаров
List<String> productNames = cart.stream()
    .map(Product::getName)
    .sorted()
    .collect(Collectors.toList());

// 6. Найти товар с максимальной стоимостью (getTotalPrice)
Optional<Product> maxProduct = cart.stream()
    .max(Comparator.comparingDouble(Product::getTotalPrice));

// 7. Проверить, есть ли товары дороже 100
boolean hasExpensive = cart.stream()
    .anyMatch(p -> p.getPrice() > 100);

// 8. Подсчитать товары дешевле 40
long cheapCount = cart.stream()
    .filter(p -> p.getPrice() < 40)
    .count();
```

---

## 📝 Задача 5: Поиск в Коллекциях

### Описание
Различные способы поиска элементов.

### Уровень 1-3: Реализуйте

```java
// Линейный поиск (O(n))
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

// Поиск в ArrayList
public static <T> int findInList(ArrayList<T> list, T element) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals(element)) {
            return i;
        }
    }
    return -1;
}

// Проверка принадлежности к HashSet (O(1))
HashSet<String> validNames = new HashSet<>(Arrays.asList("Иван", "Мария", "Петр"));
boolean isValid = validNames.contains("Иван");  // true

// Поиск в HashMap
HashMap<String, Integer> ages = new HashMap<>();
Integer age = ages.get("Иван");  // null если нет

// Поиск с условием (Stream)
Student found = students.stream()
    .filter(s -> s.getName().equals("Иван"))
    .findFirst()
    .orElse(null);
```

---

## 📊 Критерии Оценки

- ✅ Правильный выбор коллекции
- ✅ Все базовые операции (add, remove, get, contains)
- ✅ Итерирование и вывод результатов
- ✅ Сортировка данных
- ✅ Фильтрация данных
- ✅ Без ошибок компиляции

---

Удачи с практикой! После этого переходи к **Неделе 6 (Обработка Ошибок)**.