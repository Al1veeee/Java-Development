# Классы и объекты в Java

## 1. Что такое класс

Класс — это **шаблон** (чертёж), по которому создаются объекты.  
Он описывает:
- какие данные хранит объект (поля);
- что объект умеет делать (методы);
- как объект создаётся и инициализируется (конструкторы).

```java
public class Person {
    // здесь будут поля, конструкторы, методы
}
```

## 2. Что такое объект

Объект — это **экземпляр** класса, реально существующий в памяти во время выполнения программы.  
Объект создаётся с помощью оператора `new`, который:
- выделяет память;
- вызывает конструктор;
- возвращает ссылку на объект.

```java
Person person = new Person("Иван", 25, "ivan@example.com");
```

Здесь:
- `Person` — тип (класс);
- `person` — переменная-ссылка;
- `new Person(...)` — создание нового объекта.

---

## 3. Структура класса: поля, конструктор, методы

### 3.1 Поля

Поля (иногда говорят «переменные экземпляра») хранят состояние объекта.

```java
public class Person {
    private String name;
    private int age;
    private String email;
}
```

Особенности:
- объявляются внутри класса, но вне методов;
- обычно делают `private`, чтобы защитить данные (инкапсуляция).

### 3.2 Конструктор

Конструктор — специальный метод, который вызывается при создании объекта через `new`.

Правила:
- имя конструктора совпадает с именем класса;
- не имеет типа возвращаемого значения (даже `void` не пишется).

```java
public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) { // конструктор
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
```

Назначение конструктора — правильно инициализировать поля, чтобы объект сразу был в корректном состоянии.

### 3.3 Методы

Методы описывают поведение объекта — что он умеет делать.

```java
public class Person {
    // поля и конструктор опущены

    public void getInfo() {
        System.out.println("Имя: " + name +
                           ", возраст: " + age +
                           ", email: " + email);
    }

    public void haveBirthday() {
        age++;
        System.out.println(name + " празднует день рождения! Теперь ему " + age + " лет.");
    }
}
```

Особенности методов:
- могут читать и изменять поля;
- вызываются через точку: `person.getInfo();`.

---

## 4. Создание объектов с помощью `new`

Синтаксис:

```java
ТипПеременной имяПеременной = new ИмяКласса(аргументыКонструктора);
```

Пример:

```java
Person person = new Person("Иван", 25, "ivan@example.com");
```

Что здесь происходит по шагам:

1. `Person person` — объявление переменной `person` типа `Person`.
2. `new Person("Иван", 25, "ivan@example.com")` — создание нового объекта и вызов конструктора.
3. `=` — привязка ссылки на созданный объект к переменной `person`.

После этого мы можем обращаться к методам объекта:

```java
person.getInfo();
person.haveBirthday();
```

---

## 5. Ключевое слово `this`

`this` — ссылка на **текущий объект**, внутри которого выполняется код.

Основные случаи использования:

### 5.1 Отличить поле от параметра

Когда имена параметров совпадают с именами полей, используется `this`:

```java
public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;   // this.name — поле, name — параметр
        this.age = age;
        this.email = email;
    }
}
```

Без `this` компилятор будет считать, что `name` — это параметр, и вы просто присваиваете параметр самому себе.

### 5.2 Вызов другого конструктора в этом же классе

Можно из одного конструктора вызвать другой, используя `this(...)`:

```java
public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name) {
        this(name, 18, "no-email@example.com"); // вызов другого конструктора
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
```

---

## 6. Перегрузка конструкторов

**Перегрузка** — это несколько конструкторов (или методов) с одинаковым именем, но разными списками параметров.

Зачем это нужно:
- чтобы можно было создавать объекты с разным уровнем детализации данных;
- чтобы задать значения по умолчанию.

Пример:

```java
public class Person {
    private String name;
    private int age;
    private String email;

    // Конструктор 1 — все параметры
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Конструктор 2 — без email
    public Person(String name, int age) {
        this(name, age, "no-email@example.com"); // значение по умолчанию
    }

    // Конструктор 3 — без параметров
    public Person() {
        this("Неизвестно", 0, "no-email@example.com");
    }
}
```

При создании объекта компилятор сам выбирает нужный конструктор по количеству и типам аргументов:

```java
Person p1 = new Person("Иван", 25, "ivan@example.com");
Person p2 = new Person("Анна", 30);
Person p3 = new Person();
```

---

## 7. Полный пример: класс `Person`

```java
public class Person {
    // Поля
    private String name;
    private int age;
    private String email;

    // Конструктор, инициализирующий все поля
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Метод, выводящий информацию
    public void getInfo() {
        System.out.println("Имя: " + name +
                           ", возраст: " + age +
                           ", email: " + email);
    }

    // Метод, увеличивающий возраст на 1
    public void haveBirthday() {
        age++;
        System.out.println(name + " празднует день рождения! Теперь ему " + age + " лет.");
    }
}
```

Использование:

```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иван", 25, "ivan@example.com");
        person.getInfo();
        person.haveBirthday();
        person.getInfo();
    }
}
```

---

## 8. Запомни ключевые моменты

| Понятие | Что это |
|---------|---------|
| **Класс** | Шаблон для создания объектов |
| **Объект** | Экземпляр класса в памяти |
| **Поле** | Переменная, хранящая состояние |
| **Конструктор** | Метод для инициализации объекта |
| **Метод** | Функция, описывающая поведение |
| **this** | Ссылка на текущий объект |
| **new** | Оператор создания объекта |
| **private** | Модификатор для защиты данных |
| **public** | Модификатор для открытого доступа |

---

## 9. Аналогия для понимания

```
Класс — это чертёж дома
Объект — это реальный дом, построенный по чертежу
new — процесс строительства дома
Поля — комнаты и мебель в доме
Методы — действия, которые можно делать в доме (готовить, спать и т.д.)
this — сам дом (когда мы говорим о себе)
```

---

## Готово к учебе! 📚

Этот файл содержит всю необходимую теорию для понимания классов и объектов в Java. Используй его как справочник при выполнении задач.