# День 1 - Методы (Functions/Procedures)

## ***Что такое метод?***
Метод — это блок кода, который выполняет определённую задачу. 

**Методы помогают:**
- Избежать повторения кода (DRY - Don't Repeat Yourself)
- Сделать код более читаемым и организованным
- Упростить тестирование и отладку

---
### **Синтаксис:**

```
[модификатор доступа] [тип возврата] имяМетода([параметры]) { // тело метода
    return значение; // если тип возврата не void
}
```
---
### **Примеры:**

**1. Метод без параметров и возвращаемого значения**
```
public static void sayHello() {
    System.out.println("Hello");
}
```

**2. Метод с параметром и возвращаемым значением**
```
public static int Add(int a, int b) {
    return a + b;
}
```

**3. Метод с несколькими параметрами**
```
public static double calculateAverage(int num1, int num2, int num3) {
    return (num1 + num2 + num3)/3.0;
}
```

**4. Вызов методов 1-3**
```
sayHello(); // Output: Hello
int result = Add(5, 3); // result = 8
double avg = calculateAverage(10, 20, 30); // avg = 20.0