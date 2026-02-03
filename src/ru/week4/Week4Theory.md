# 🎯 Неделя 4: ООП Часть 2 - Наследование, Полиморфизм, Интерфейсы

## 📚 Теоретический материал

### 1. Наследование (Inheritance)

**Что это?** Наследование позволяет создавать иерархию классов, где один класс (подкласс/child) наследует свойства и методы другого класса (суперкласс/parent).

#### Синтаксис:
```java
// Родительский класс (базовый класс)
public class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void sleep() {
        System.out.println(name + " спит");
    }
    
    public void eat() {
        System.out.println(name + " ест");
    }
}

// Дочерний класс наследует Animal
public class Dog extends Animal {
    private String breed;
    
    // Конструктор дочернего класса
    public Dog(String name, int age, String breed) {
        super(name, age);  // Вызываем конструктор родителя
        this.breed = breed;
    }
    
    // Новый метод, специфичный для Dog
    public void bark() {
        System.out.println(name + " лает: Гав!");
    }
}
```

#### Ключевые моменты:
- **`extends`** — ключевое слово для наследования
- **`super()`** — вызов конструктора родителя
- **`super.method()`** — вызов метода родителя
- **`protected`** — модификатор для доступа из подклассов

#### Иерархия классов:
```
        Animal (суперкласс)
         /  |  \
       Dog Cat Bird
       
Каждый класс наследует методы Animal:
Dog: sleep(), eat(), bark()
Cat: sleep(), eat(), meow()
Bird: sleep(), eat(), fly()
```

---

### 2. Переопределение методов (Method Overriding)

**Что это?** Подкласс может переопределить метод родителя с новой реализацией.

```java
public class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

public class Dog extends Animal {
    @Override  // Аннотация (рекомендуется всегда использовать)
    public void makeSound() {
        System.out.println("Гав! Гав!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

// Использование:
public static void main(String[] args) {
    Animal dog = new Dog();
    Animal cat = new Cat();
    
    dog.makeSound();  // Вывод: "Гав! Гав!"
    cat.makeSound();  // Вывод: "Мяу!"
}
```

#### Правила переопределения:
- Имя метода, параметры и тип возврата должны быть **идентичны**
- Модификатор доступа не может быть **более строгим**
- Не может выбросить **больше исключений**, чем родитель
- Используйте **`@Override`** аннотацию

---

### 3. Полиморфизм (Polymorphism)

**Что это?** "Многолики" — один интерфейс, множество реализаций.

```java
// ПОЛИМОРФИЗМ В ДЕЙСТВИИ:

Animal[] animals = {
    new Dog("Рекс", 5, "Овчарка"),
    new Cat("Мурка", 3, "Сиамская"),
    new Bird("Попугай", 2, "Ара")
};

// Один цикл работает со всеми животными:
for (Animal animal : animals) {
    animal.makeSound();  // Вызывает ПРАВИЛЬНЫЙ метод для каждого класса!
}

// Вывод:
// Гав! Гав!
// Мяу!
// Крик!
```

**Почему это мощно?**
- Работаете с родительским типом, но вызываются методы дочерних классов
- Легко добавлять новые классы без изменения существующего кода
- Принцип "Open/Closed" в SOLID

---

### 4. Абстрактные классы (Abstract Classes)

**Когда использовать?** Когда класс не должен быть инстанцирован, а только служить основой.

```java
// Нельзя создать: new Shape();
public abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Абстрактный метод — подклассы ДОЛЖНЫ переопределить
    public abstract double getArea();
    
    // Конкретный метод — уже имеет реализацию
    public void printColor() {
        System.out.println("Цвет: " + color);
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

// Использование:
Shape circle = new Circle("красный", 5);
Shape rect = new Rectangle("синий", 4, 6);

System.out.println("Площадь круга: " + circle.getArea());      // 78.53...
System.out.println("Площадь прямоугольника: " + rect.getArea()); // 24
```

#### Ключевые моменты:
- **`abstract class`** — класс с абстрактными методами
- **`abstract void method()`** — метод без реализации; подклассы должны его реализовать
- **Нельзя создавать объекты** абстрактного класса
- **Может содержать** конкретные методы и переменные

---

### 5. Интерфейсы (Interfaces)

**Что это?** "Договор" — класс обещает реализовать все методы интерфейса.

```java
// Интерфейс — только сигнатуры методов
public interface Animal {
    void eat();
    void sleep();
    void makeSound();
}

// Интерфейс для летающих объектов
public interface Flyable {
    void fly();
    void land();
}

// Класс может реализовывать НЕСКОЛЬКО интерфейсов
public class Bird implements Animal, Flyable {
    @Override
    public void eat() {
        System.out.println("Птица клюёт зёрна");
    }
    
    @Override
    public void sleep() {
        System.out.println("Птица спит на ветке");
    }
    
    @Override
    public void makeSound() {
        System.out.println("Птица поёт");
    }
    
    @Override
    public void fly() {
        System.out.println("Птица летит");
    }
    
    @Override
    public void land() {
        System.out.println("Птица приземлилась");
    }
}

// Использование:
Bird sparrow = new Bird();
sparrow.fly();          // Полиморфизм
sparrow.eat();
sparrow.makeSound();
```

#### Интерфейсы vs Абстрактные классы:

| Аспект | Интерфейс | Абстрактный класс |
|--------|-----------|------------------|
| Наследование | `implements` | `extends` |
| Количество | Может быть много | Только один |
| Переменные | `static final` | Любые |
| Методы | Только сигнатуры (Java 8+) | Могут быть реализованы |
| Конструкторы | Нет | Могут быть |

```java
// Java 8+ позволяет:
public interface Vehicle {
    void start();
    
    default void honk() {  // Default метод
        System.out.println("Бип!");
    }
    
    static void printInfo() {  // Static метод
        System.out.println("Это транспортное средство");
    }
}
```

---

### 6. Инкапсуляция (Encapsulation) и Getters/Setters

**Что это?** Скрывание деталей реализации, предоставление контролируемого доступа.

```java
public class Person {
    // private — доступно только внутри класса
    private String name;
    private int age;
    private double salary;
    
    // Геттер для name
    public String getName() {
        return name;
    }
    
    // Сеттер для name с валидацией
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Ошибка: Имя не может быть пустым");
        }
    }
    
    // Геттер для age
    public int getAge() {
        return age;
    }
    
    // Сеттер для age с валидацией
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Ошибка: Некорректный возраст");
        }
    }
    
    // Зарплата — может быть установлена через специальный метод
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
    
    // Бизнес-логика
    public void giveBonusPercent(double percent) {
        salary += salary * (percent / 100);
    }
}

// Использование:
Person person = new Person();
person.setName("Иван");
person.setAge(25);
person.setSalary(50000);

System.out.println(person.getName());    // Иван
System.out.println(person.getAge());     // 25

person.giveBonusPercent(10);             // Зарплата + 10%
System.out.println(person.getSalary());  // 55000
```

**Преимущества:**
- ✅ Контроль доступа к переменным
- ✅ Валидация данных
- ✅ Возможность изменить реализацию без изменения интерфейса
- ✅ Обеспечение целостности данных

---

## 🎯 Ключевые Принципы

### Иерархия наследования:
```
Object (все классы наследуют Object)
  ↓
  ├─ Animal
  │   ├─ Dog
  │   ├─ Cat
  │   └─ Bird
  │
  ├─ Vehicle
  │   ├─ Car
  │   └─ Bicycle
  │
  └─ Shape
      ├─ Circle
      └─ Rectangle
```

### Когда использовать что:

1. **Наследование** — отношение "является" (Dog **является** Animal)
2. **Интерфейсы** — функциональность (Bird **может летать** → implements Flyable)
3. **Абстрактные классы** — общая логика для группы классов

```java
// Хороший пример:
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Машина заводится");
    }
}

interface Swimmable {
    void swim();
}

class AmphibiousCar extends Car implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Машина плывет");
    }
}
```

---

## 📌 Памятка по Модификаторам Доступа

| Модификатор | Класс | Пакет | Подкласс | Остальное |
|------------|-------|-------|----------|-----------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `default` (нет слова) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

---

Это основы ООП Части 2. Далее идут практические задачи для закрепления!