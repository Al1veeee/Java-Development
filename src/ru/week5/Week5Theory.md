# 🎯 Неделя 5: Коллекции и Структуры Данных

## 📚 Теоретический материал

### 1. Java Collections Framework

**Что это?** Набор интерфейсов и классов для работы с группами объектов.

```
Collection Иерархия:
┌─ Collection
│  ├─ List (Список, с порядком)
│  │  ├─ ArrayList
│  │  └─ LinkedList
│  ├─ Set (Набор, без дубликатов)
│  │  ├─ HashSet
│  │  └─ TreeSet
│  └─ Queue (Очередь, FIFO)
└─ Map (Словарь, ключ-значение)
   ├─ HashMap
   └─ TreeMap
```

---

### 2. Массивы (Arrays)

**Уже знаете, но напомним:**

```java
// Объявление и инициализация
int[] numbers = {1, 2, 3, 4, 5};
String[] names = new String[10];

// Доступ к элементам
int first = numbers[0];
numbers[0] = 10;

// Длина массива
int length = numbers.length;

// Итерирование
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// for-each синтаксис
for (int number : numbers) {
    System.out.println(number);
}

// Проблемы:
// - Размер ФИКСИРОВАН
// - Нельзя легко добавлять/удалять элементы
// - Неудобно искать элементы
```

---

### 3. ArrayList — Динамический Список

**Что это?** Массив, который может расти и сжиматься.

```java
import java.util.*;

// Создание и добавление элементов
ArrayList<String> fruits = new ArrayList<>();
fruits.add("Яблоко");
fruits.add("Банан");
fruits.add("Апельсин");

System.out.println(fruits.size());  // 3

// Доступ к элементам
String first = fruits.get(0);       // "Яблоко"
fruits.set(1, "Груша");             // Заменить элемент

// Удаление элементов
fruits.remove(0);                   // Удалить первый элемент
fruits.remove("Апельсин");          // Удалить по значению

// Проверка наличия элемента
boolean hasApple = fruits.contains("Яблоко");

// Итерирование
for (String fruit : fruits) {
    System.out.println(fruit);
}

// Очищение списка
fruits.clear();

// Полезные методы:
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(5);
numbers.add(2);
numbers.add(8);
numbers.add(1);

Collections.sort(numbers);          // Сортировка: [1, 2, 5, 8]
Collections.reverse(numbers);       // Обратный порядок: [8, 5, 2, 1]
int max = Collections.max(numbers); // Максимум: 8
int min = Collections.min(numbers); // Минимум: 1
```

#### Практический пример:

```java
ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Иван", 85));
students.add(new Student("Мария", 92));
students.add(new Student("Петр", 78));

// Вывод всех студентов
for (Student student : students) {
    System.out.println(student);
}

// Поиск студента по имени
public Student findStudent(String name, ArrayList<Student> students) {
    for (Student student : students) {
        if (student.getName().equals(name)) {
            return student;
        }
    }
    return null;
}

// Вывод студентов с оценкой > 80
for (Student student : students) {
    if (student.getGrade() > 80) {
        System.out.println(student.getName());
    }
}
```

---

### 4. LinkedList

**Когда использовать?** Когда много добавлений/удалений в середину.

```java
LinkedList<String> names = new LinkedList<>();
names.add("Иван");
names.add("Мария");
names.add("Петр");

// Специфичные методы LinkedList:
names.addFirst("Алекс");     // Добавить в начало
names.addLast("Дмитрий");    // Добавить в конец
String first = names.getFirst();  // Получить первый
String last = names.getLast();    // Получить последний
names.removeFirst();          // Удалить первый
names.removeLast();           // Удалить последний

// Для Stack (стек) и Queue (очередь):
LinkedList<Integer> queue = new LinkedList<>();
queue.add(1);      // Добавить (в конец)
queue.add(2);
queue.add(3);
int front = queue.remove();  // Удалить первый (FIFO)
```

**ArrayList vs LinkedList:**

| Операция | ArrayList | LinkedList |
|----------|-----------|-----------|
| Доступ по индексу | O(1) ✅ | O(n) |
| Добавление в конец | O(1) | O(1) ✅ |
| Добавление в начало | O(n) | O(1) ✅ |
| Удаление в середине | O(n) | O(n) |

---

### 5. HashMap — Словарь (Ключ-Значение)

**Что это?** Хранит пары "ключ → значение".

```java
import java.util.*;

// Создание HashMap
HashMap<String, Integer> ages = new HashMap<>();

// Добавление элементов
ages.put("Иван", 25);
ages.put("Мария", 30);
ages.put("Петр", 28);

// Получение значения по ключу
int ivansAge = ages.get("Иван");     // 25
int unknownAge = ages.get("Ольга");  // null

// Проверка наличия ключа
boolean hasIvan = ages.containsKey("Иван");        // true
boolean hasAge30 = ages.containsValue(30);         // true

// Удаление
ages.remove("Петр");

// Количество элементов
int size = ages.size();

// Итерирование по ключам
for (String name : ages.keySet()) {
    System.out.println(name);
}

// Итерирование по значениям
for (Integer age : ages.values()) {
    System.out.println(age);
}

// Итерирование по парам (ключ-значение)
for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Получение с дефолтным значением
int age = ages.getOrDefault("Неизвестный", 0);  // 0

// Обновление значения
ages.put("Иван", 26);  // Заменить существующий ключ

// Очистить все
ages.clear();
```

#### Практический пример:

```java
// Подсчет частоты символов в строке
String text = "hello world";
HashMap<Character, Integer> charCount = new HashMap<>();

for (char c : text.toCharArray()) {
    if (c == ' ') continue;
    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
}

// Результат: {h=1, e=1, l=3, o=2, w=1, r=1, d=1}
for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Словарь (контакты)
HashMap<String, String> phoneBook = new HashMap<>();
phoneBook.put("Иван", "+7-123-456-78-90");
phoneBook.put("Мария", "+7-987-654-32-10");

String ivanPhone = phoneBook.get("Иван");
if (phoneBook.containsKey("Петр")) {
    System.out.println("Номер Петра: " + phoneBook.get("Петр"));
} else {
    System.out.println("Номера Петра в книге нет");
}
```

---

### 6. HashSet — Набор без Дубликатов

**Что это?** Коллекция, где каждый элемент уникален.

```java
import java.util.*;

HashSet<String> uniqueNames = new HashSet<>();
uniqueNames.add("Иван");
uniqueNames.add("Мария");
uniqueNames.add("Иван");      // Не будет добавлен (уже есть)

System.out.println(uniqueNames.size());  // 2

// Проверка наличия элемента
if (uniqueNames.contains("Иван")) {
    System.out.println("Иван в наборе");
}

// Итерирование (порядок НЕ гарантирован)
for (String name : uniqueNames) {
    System.out.println(name);
}

// Удаление элемента
uniqueNames.remove("Мария");

// Очистить
uniqueNames.clear();
```

#### Практический пример:

```java
// Найти уникальные элементы в массиве
int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
HashSet<Integer> unique = new HashSet<>();

for (int num : numbers) {
    unique.add(num);
}

System.out.println("Уникальные: " + unique);  // [1, 2, 3, 4]

// Удалить дубликаты из ArrayList
ArrayList<String> items = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "B"));
HashSet<String> uniqueItems = new HashSet<>(items);
ArrayList<String> uniqueList = new ArrayList<>(uniqueItems);
```

---

### 7. TreeSet — Отсортированное Множество

**Что это?** HashSet, но элементы отсортированы.

```java
TreeSet<Integer> numbers = new TreeSet<>();
numbers.add(5);
numbers.add(2);
numbers.add(8);
numbers.add(1);

// Автоматически отсортировано: [1, 2, 5, 8]
for (Integer num : numbers) {
    System.out.println(num);
}

// Дополнительные методы:
int first = numbers.first();        // 1
int last = numbers.last();          // 8
int ceiling = numbers.ceiling(3);   // 5 (первый >= 3)
int floor = numbers.floor(3);       // 2 (первый <= 3)

// Удалить первый и последний
numbers.pollFirst();  // Удалить и вернуть минимум
numbers.pollLast();   // Удалить и вернуть максимум
```

---

### 8. Stream API и Функциональное Программирование

**Что это?** Позволяет писать код в функциональном стиле.

```java
import java.util.*;

ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

// Filter — отфильтровать элементы
List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// Результат: [2, 4, 6]

// Map — преобразовать элементы
List<Integer> doubled = numbers.stream()
    .map(n -> n * 2)
    .collect(Collectors.toList());
// Результат: [2, 4, 6, 8, 10, 12]

// Reduce — свернуть в одно значение
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);
// Результат: 21

// Цепочка операций
int result = numbers.stream()
    .filter(n -> n > 2)          // [3, 4, 5, 6]
    .map(n -> n * 2)             // [6, 8, 10, 12]
    .reduce(0, Integer::sum);    // 36

// Count
long count = numbers.stream()
    .filter(n -> n > 3)
    .count();
// Результат: 3

// Sort
List<Integer> sorted = numbers.stream()
    .sorted()
    .collect(Collectors.toList());

// Обратный порядок
List<Integer> reversed = numbers.stream()
    .sorted((a, b) -> b.compareTo(a))
    .collect(Collectors.toList());

// ForEach
numbers.stream()
    .filter(n -> n > 2)
    .forEach(n -> System.out.println(n));  // Вывести: 3, 4, 5, 6
```

#### Практический пример со студентами:

```java
ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Иван", 85));
students.add(new Student("Мария", 92));
students.add(new Student("Петр", 78));
students.add(new Student("Анна", 88));

// Получить имена студентов с оценкой > 85
List<String> highGradeStudents = students.stream()
    .filter(s -> s.getGrade() > 85)
    .map(s -> s.getName())
    .collect(Collectors.toList());
// Результат: ["Мария", "Анна"]

// Средняя оценка
double averageGrade = students.stream()
    .mapToDouble(Student::getGrade)
    .average()
    .orElse(0);

// Максимальная оценка
int maxGrade = students.stream()
    .mapToInt(Student::getGrade)
    .max()
    .orElse(0);

// Сортировка по оценке (убывание)
List<Student> sortedByGrade = students.stream()
    .sorted((s1, s2) -> s2.getGrade() - s1.getGrade())
    .collect(Collectors.toList());
```

---

### 9. Iterator — Итератор

**Что это?** Способ обойти элементы коллекции.

```java
import java.util.*;

ArrayList<String> fruits = new ArrayList<>();
fruits.add("Яблоко");
fruits.add("Банан");
fruits.add("Апельсин");

// Способ 1: for-each
for (String fruit : fruits) {
    System.out.println(fruit);
}

// Способ 2: Iterator (более гибкий)
Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    String fruit = iterator.next();
    System.out.println(fruit);
    
    // Можно безопасно удалять элементы
    if (fruit.equals("Банан")) {
        iterator.remove();  // Безопасное удаление
    }
}

// Способ 3: Classic for loop
for (int i = 0; i < fruits.size(); i++) {
    System.out.println(fruits.get(i));
}

// Способ 4: forEach метод (Java 8+)
fruits.forEach(fruit -> System.out.println(fruit));
```

**Осторожно!** Нельзя удалять элементы через `collection.remove()` во время итерации:

```java
// ❌ НЕПРАВИЛЬНО — будет ошибка
for (String fruit : fruits) {
    if (fruit.equals("Банан")) {
        fruits.remove(fruit);  // ConcurrentModificationException
    }
}

// ✅ ПРАВИЛЬНО
Iterator<String> it = fruits.iterator();
while (it.hasNext()) {
    if (it.next().equals("Банан")) {
        it.remove();  // Безопасное удаление
    }
}
```

---

### 10. Сортировка Коллекций

```java
import java.util.*;

// Сортировка примитивных типов
ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
Collections.sort(numbers);           // [1, 2, 5, 8, 9]
Collections.sort(numbers, Collections.reverseOrder());  // [9, 8, 5, 2, 1]

// Сортировка строк
ArrayList<String> names = new ArrayList<>(Arrays.asList("Мария", "Иван", "Анна"));
Collections.sort(names);             // Алфавитный порядок
Collections.sort(names, Collections.reverseOrder());  // Обратный

// Сортировка объектов (нужен Comparator)
ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Иван", 85));
students.add(new Student("Мария", 92));
students.add(new Student("Петр", 78));

// По оценке (возрастание)
Collections.sort(students, (s1, s2) -> s1.getGrade() - s2.getGrade());

// По оценке (убывание)
Collections.sort(students, (s1, s2) -> s2.getGrade() - s1.getGrade());

// По имени (алфавитный)
Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
```

---

## 📌 Шпаргалка по Коллекциям

```
┌─────────────────────────────────────┐
│ Выбор правильной коллекции          │
├─────────────────────────────────────┤
│ ArrayList     — часто используется  │
│ LinkedList    — много добавлений    │
│ HashSet       — уникальные элементы │
│ TreeSet       — отсортированные     │
│ HashMap       — ключ-значение       │
│ TreeMap       — отсортированные     │
│               ключ-значение         │
└─────────────────────────────────────┘

┌─────────────────────────────────────┐
│ Методы, которые нужно знать:        │
├─────────────────────────────────────┤
│ add(E)        — добавить            │
│ remove(E)     — удалить             │
│ get(int)      — получить (List)     │
│ contains(E)   — проверить наличие   │
│ size()        — количество           │
│ clear()       — очистить            │
│ isEmpty()     — пусто ли?           │
│ put(K, V)     — добавить (Map)      │
│ get(K)        — получить (Map)      │
│ keySet()      — все ключи (Map)     │
│ values()      — все значения (Map)  │
└─────────────────────────────────────┘
```

---

Теория завершена! Переходи к практическим задачам для закрепления.