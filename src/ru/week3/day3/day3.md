### Тема 2: Конструкторы

**Что это?**
Конструктор — это специальный метод, который вызывается при создании объекта. Он инициализирует поля объекта.

**Характеристики конструктора:**
- Имя конструктора совпадает с именем класса
- Не имеет типа возврата (даже void)
- Может иметь параметры
- Вызывается автоматически с помощью `new`

**Типы конструкторов:**

**1) Конструктор по умолчанию (Default Constructor)**
```java
public class Student {
    String name;
    int age;
    
    // Конструктор по умолчанию (параметров нет)
    public Student() {
        name = "Unknown";
        age = 0;
    }
}

Student student1 = new Student(); // вызывается конструктор по умолчанию
System.out.println(student1.name); // Output: Unknown
System.out.println(student1.age);  // Output: 0
```

**2) Параметризированный конструктор**
```java
public class Student {
    String name;
    int age;
    
    // Параметризированный конструктор
    public Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }
}

Student student1 = new Student("Alice", 20);
System.out.println(student1.name); // Output: Alice
System.out.println(student1.age);  // Output: 20
```

**3) Перегрузка конструкторов (Constructor Overloading)**
```java
public class Person {
    String name;
    int age;
    String city;
    
    // Конструктор 1: только имя
    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.city = "Unknown";
    }
    
    // Конструктор 2: имя и возраст
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.city = "Unknown";
    }
    
    // Конструктор 3: все параметры
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}

Person p1 = new Person("Bob");                      // Конструктор 1
Person p2 = new Person("Alice", 25);                // Конструктор 2
Person p3 = new Person("Charlie", 30, "Moscow");    // Конструктор 3
```

**Ключевое слово `this`:**
`this` ссылается на текущий объект. Используется для различия между параметром и полем:

```java
public class Car {
    String brand;
    
    public Car(String brand) {
        this.brand = brand;  // this.brand - это поле класса, brand - параметр
    }
}
```

---

### Геттеры и сеттеры

**Смотри в "Person"**
