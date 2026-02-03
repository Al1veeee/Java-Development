# 💻 Неделя 4: ООП Часть 2 - Практические Задачи

## 🎯 Структура практики

Каждая задача имеет три уровня сложности:
- **Уровень 1** — базовые концепции (обязателен)
- **Уровень 2** — применение с усложнением (рекомендуется)
- **Уровень 3** — глубокое понимание (продвинутые)

---

## 📝 Задача 1: Иерархия Животных

### Описание
Создать систему классов для представления животных с наследованием и полиморфизмом.

### Уровень 1: Базовая иерархия

```java
// Создайте класс Animal со следующими:
// - protected String name
// - protected int age
// - public void eat() → выводит "{name} ест"
// - public void sleep() → выводит "{name} спит"
// - public abstract void makeSound()

// Создайте класс Dog extends Animal
// - private String breed
// - @Override makeSound() → "Гав! Гав!"
// - public void fetch() → "Собака приносит мяч"

// Создайте класс Cat extends Animal
// - private String color
// - @Override makeSound() → "Мяу!"
// - public void scratch() → "Кошка царапает когтистыми лапами"

// Тестовый код:
public static void main(String[] args) {
    Dog dog = new Dog("Рекс", 5, "Овчарка");
    Cat cat = new Cat("Мурка", 3, "чёрная");
    
    dog.eat();        // Рекс ест
    dog.makeSound();  // Гав! Гав!
    dog.fetch();      // Собака приносит мяч
    
    cat.sleep();      // Мурка спит
    cat.makeSound();  // Мяу!
    cat.scratch();    // Кошка царапает когтистыми лапами
}
```

### Уровень 2: Полиморфизм в действии

```java
// Добавьте класс Bird extends Animal
// - private double wingspan
// - @Override makeSound() → "Чирик!"
// - public void fly() → "Птица летит на высоте"

// Используйте полиморфизм:
Animal[] animals = {
    new Dog("Рекс", 5, "Овчарка"),
    new Cat("Мурка", 3, "чёрная"),
    new Bird("Попугай", 2, 1.5)
};

// Цикл, который вызывает makeSound() для каждого животного
for (Animal animal : animals) {
    animal.makeSound();  // Правильный метод для каждого класса
    animal.eat();
}

// Дополнительно: добавьте поле age в тестовых объектов и
// выведите информацию о каждом животном
```

### Уровень 3: Продвинутое наследование

```java
// Создайте интерфейс Swimmable
// - void swim()

// Создайте интерфейс Playable
// - void play()

// Создайте класс Duck extends Bird implements Swimmable, Playable
// - String waterType (пресная или соленая)
// - @Override swim() → "Утка плывет"
// - @Override play() → "Утка играет в воде"
// - public void quack() → "Кря-кря!"

// Система, которая работает с полиморфными ссылками:
Animal duck = new Duck("Дональд", 3, 1.2, "пресная");
Swimmable swimmingDuck = new Duck("Дональд", 3, 1.2, "пресная");

duck.makeSound();           // Чирик!
swimmingDuck.swim();        // Утка плывет

// Тип приведение (casting):
if (duck instanceof Swimmable) {
    ((Swimmable) duck).swim();  // Утка плывет
}
```

---

## 📝 Задача 2: Система Фигур (Shapes)

### Описание
Создать систему геометрических фигур с расчетом площадей и периметров.

### Уровень 1: Базовые фигуры

```java
// Создайте абстрактный класс Shape
// - protected String color
// - public abstract double getArea()
// - public abstract double getPerimeter()
// - public void printInfo() → выводит цвет и площадь

// Создайте класс Circle extends Shape
// - private double radius
// - @Override getArea() → π * r²
// - @Override getPerimeter() → 2 * π * r

// Создайте класс Rectangle extends Shape
// - private double width, height
// - @Override getArea() → width * height
// - @Override getPerimeter() → 2 * (width + height)

// Тестовый код:
public static void main(String[] args) {
    Circle circle = new Circle("красный", 5);
    Rectangle rect = new Rectangle("синий", 4, 6);
    
    System.out.println("Площадь круга: " + circle.getArea());
    System.out.println("Периметр прямоугольника: " + rect.getPerimeter());
    
    circle.printInfo();
    rect.printInfo();
}
```

### Уровень 2: Расширенная иерархия

```java
// Добавьте класс Triangle extends Shape
// - private double sideA, sideB, sideC
// - @Override getArea() → используйте формулу Герона
// - @Override getPerimeter() → sideA + sideB + sideC

// Добавьте класс Square extends Rectangle
// - конструктор принимает только сторону
// - вызывает super(side, side)

// Создайте массив фигур и:
// 1. Вычислите общую площадь всех фигур
// 2. Найдите фигуру с максимальной площадью
// 3. Найдите фигуру с максимальным периметром

Shape[] shapes = {
    new Circle("красный", 5),
    new Rectangle("синий", 4, 6),
    new Triangle("зелёный", 3, 4, 5),
    new Square("жёлтый", 5)
};

double totalArea = 0;
Shape maxAreaShape = shapes[0];

for (Shape shape : shapes) {
    totalArea += shape.getArea();
    if (shape.getArea() > maxAreaShape.getArea()) {
        maxAreaShape = shape;
    }
}

System.out.println("Общая площадь: " + totalArea);
System.out.println("Максимальная площадь: " + maxAreaShape.getArea());
```

### Уровень 3: Интерфейсы и сравнение

```java
// Создайте интерфейс Comparable (не путать с java.lang.Comparable)
// - int compareByArea(Shape other)

// Реализуйте его во всех фигурах
// compareByArea возвращает:
// - положительное число, если эта фигура больше
// - отрицательное число, если эта фигура меньше
// - ноль, если они равны

// Напишите метод для сортировки фигур по площади:
public static Shape[] sortShapesByArea(Shape[] shapes) {
    Shape[] sorted = shapes.clone();
    for (int i = 0; i < sorted.length - 1; i++) {
        for (int j = 0; j < sorted.length - i - 1; j++) {
            // Используйте Comparable интерфейс
            if (sorted[j].compareByArea(sorted[j+1]) > 0) {
                Shape temp = sorted[j];
                sorted[j] = sorted[j+1];
                sorted[j+1] = temp;
            }
        }
    }
    return sorted;
}
```

---

## 📝 Задача 3: Система Сотрудников

### Описание
Создать иерархию сотрудников компании с разными ролями и зарплатой.

### Уровень 1: Базовая иерархия

```java
// Создайте абстрактный класс Employee
// - protected String name
// - protected String id
// - protected double baseSalary
// - public abstract double calculateSalary()
// - public abstract void displayRole()

// Создайте класс Manager extends Employee
// - private int teamSize
// - @Override calculateSalary() → baseSalary + (100 * teamSize)
// - @Override displayRole() → "Менеджер с командой из {teamSize} человек"

// Создайте класс Developer extends Employee
// - private String programmingLanguage
// - private int yearsOfExperience
// - @Override calculateSalary() → baseSalary + (500 * yearsOfExperience)
// - @Override displayRole() → "Разработчик на {programmingLanguage}"

// Тестовый код:
Manager manager = new Manager("Иван", "M001", 50000, 5);
Developer developer = new Developer("Петр", "D001", 40000, "Java", 3);

System.out.println(manager.displayRole());
System.out.println("Зарплата: " + manager.calculateSalary());

System.out.println(developer.displayRole());
System.out.println("Зарплата: " + developer.calculateSalary());
```

### Уровень 2: Интерфейсы и бонусы

```java
// Создайте интерфейс Promotable
// - void promote()

// Реализуйте его в Manager и Developer
// - Manager: yearsOfWork++, teamSize += 2
// - Developer: yearsOfExperience++

// Добавьте класс Intern extends Employee
// - private String university
// - @Override calculateSalary() → baseSalary (без доп. выплат)
// - @Override displayRole() → "Стажер из {university}"

// Создайте систему управления:
Employee[] employees = {
    new Manager("Иван", "M001", 50000, 5),
    new Developer("Петр", "D001", 40000, "Java", 3),
    new Developer("Мария", "D002", 40000, "Python", 2),
    new Intern("Алекс", "I001", 15000, "МГУ")
};

// 1. Найдите среднюю зарплату
// 2. Найдите максимальную зарплату
// 3. Вычислите общий фонд оплаты труда
```

### Уровень 3: Продвинутые операции

```java
// Добавьте интерфейс Bonusable
// - void giveBonus(double amount)

// Реализуйте его для всех, но по-разному:
// - Manager: бонус + 20% к зарплате
// - Developer: бонус + 10% к зарплате
// - Intern: бонус без процентов

// Создайте класс Contractor (не наследует Employee!)
// - Это отдельная иерархия
// - implements Bonusable
// - private double hourlyRate
// - private int hoursWorked

// Создайте метод, который выписывает зарплату всем (Bonusable объектам):
public static void distributeMonthlyBonus(Bonusable[] employees, double bonus) {
    for (Bonusable emp : employees) {
        emp.giveBonus(bonus);
    }
}

// Работает как с Employee, так и с Contractor, благодаря интерфейсу!
```

---

## 📝 Задача 4: Система Транспорта

### Описание
Создать иерархию транспортных средств с различными функциональностями.

### Уровень 1: Базовые транспортные средства

```java
// Создайте абстрактный класс Vehicle
// - protected String brand
// - protected String model
// - protected int year
// - public abstract void start()
// - public abstract void stop()
// - public abstract double getMaxSpeed()

// Создайте класс Car extends Vehicle
// - private int numberOfDoors
// - @Override start() → "Машина заводится"
// - @Override stop() → "Машина тормозит"
// - @Override getMaxSpeed() → 180

// Создайте класс Motorcycle extends Vehicle
// - private boolean hasSideCar
// - @Override start() → "Мотоцикл запущен!"
// - @Override stop() → "Мотоцикл остановлен"
// - @Override getMaxSpeed() → 220

public static void main(String[] args) {
    Car car = new Car("Toyota", "Camry", 2022, 4);
    Motorcycle moto = new Motorcycle("Harley", "Davidson", 2021, false);
    
    car.start();
    System.out.println("Максимальная скорость: " + car.getMaxSpeed());
}
```

### Уровень 2: Интерфейсы и функциональности

```java
// Создайте интерфейс Chargeable
// - void charge()
// - int getBatteryPercent()

// Создайте класс ElectricCar extends Car implements Chargeable
// - private int batteryPercent
// - @Override charge() → batteryPercent = 100
// - @Override getBatteryPercent() → вернуть batteryPercent
// - @Override getMaxSpeed() → 200 (но зависит от батареи)

// Создайте интерфейс FlyCapable
// - void takeOff()
// - void land()

// Создайте класс Helicopter extends Vehicle implements FlyCapable
// - @Override takeOff() → "Вертолет взлетает"
// - @Override land() → "Вертолет приземляется"

ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2023, 4);
tesla.start();
tesla.charge();
System.out.println("Батарея: " + tesla.getBatteryPercent() + "%");

Helicopter heli = new Helicopter("Airbus", "H125", 2022);
heli.start();
heli.takeOff();
```

### Уровень 3: Комплексная система

```java
// Создайте класс Garage с методами:
// - addVehicle(Vehicle v)
// - removeVehicle(String model)
// - startAllVehicles()
// - stopAllVehicles()
// - findFastestVehicle()
// - chargeAllElectric()  (использует Chargeable)

// Используйте полиморфизм для работы с разными типами

Garage garage = new Garage();
garage.addVehicle(new Car("Toyota", "Camry", 2022, 4));
garage.addVehicle(new ElectricCar("Tesla", "Model 3", 2023, 4));
garage.addVehicle(new Motorcycle("Harley", "Davidson", 2021, false));

garage.startAllVehicles();
garage.chargeAllElectric();
Vehicle fastest = garage.findFastestVehicle();
System.out.println("Самый быстрый: " + fastest.getBrand());
```

---

## 🎯 Дополнительные Упражнения

### Упражнение 1: instanceof и Type Casting
```java
// Напишите метод, который работает с массивом Shape[]
// и выполняет специальные операции для каждого типа:

public static void processShapes(Shape[] shapes) {
    for (Shape shape : shapes) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            // Специфичные операции для круга
        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            // Специфичные операции для прямоугольника
        }
    }
}
```

### Упражнение 2: super() и super.method()
```java
// Покажите правильное использование super в конструкторах
// и вызов методов родителя

public class Child extends Parent {
    private String childField;
    
    public Child(String parentField, String childField) {
        super(parentField);  // Обязателен, если родитель требует параметры
        this.childField = childField;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();  // Сначала вывести информацию родителя
        System.out.println("Child: " + childField);
    }
}
```

### Упражнение 3: Interface Segregation
```java
// Создайте несколько маленьких, специфичных интерфейсов
// вместо одного большого:

// Хорошо:
interface Eatable { void eat(); }
interface Sleepable { void sleep(); }
interface Movable { void move(); }

// Плохо:
interface Animal {
    void eat();
    void sleep();
    void move();
    void fly();      // Не все животные летают!
    void swim();     // Не все животные плавают!
}
```

---

## 📊 Критерии Оценки

### Для каждой задачи:
- ✅ Правильная иерархия классов (extends/implements)
- ✅ Правильное переопределение методов (@Override)
- ✅ Правильное использование super()
- ✅ Правильные модификаторы доступа
- ✅ Демонстрация полиморфизма
- ✅ Без ошибок компиляции
- ✅ Логические результаты при запуске

### Бонусные баллы:
- ✅ Дополнительные интерфейсы сверх требуемых
- ✅ Чистый, читаемый код
- ✅ JavaDoc комментарии
- ✅ Обработка граничных случаев

---

## 💡 Советы для Успеха

1. **Начните с Уровня 1** — убедитесь, что понимаете основы
2. **Компилируйте часто** — исправляйте ошибки сразу
3. **Используйте @Override** — IDE подскажет, если что-то неправильно
4. **Тестируйте полиморфизм** — создавайте массивы и циклы
5. **Читайте сообщения об ошибках** — они очень информативны
6. **Рисуйте диаграммы классов** — понимание иерархии критично
7. **Пускайте через debugger** — смотрите, как выполняется код

---

Удачи с практикой! После выполнения всех задач переходи к Неделе 5 (Коллекции).