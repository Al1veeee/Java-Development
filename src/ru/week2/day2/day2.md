# День 2: Параметры и Аргументы

## В чём разница?

* Параметр — переменная определяемая в методе
* Аргумент — значение передаваемое при вызове метода

```
public static void multiply(int a, int b) { // a и b — это параметры
    return a * b;
}

int result = multiply(4, 5); // 4 и 5 — это аргументы
```
---

### **Способы решения задачи**

Задача 2.2: Сумма Цифр Числа:

```
Метод: sumOfDigits(int number)
Возвращает: сумму всех цифр числа
Пример: sumOfDigits(123) → 6 (1+2+3)
Подсказка: используйте цикл while с операцией % (остаток деления)
```

**Решение №1:**

Реализовано через перевод числа в строковый вид, затем в символьный и наконец создания нового целочисленного массива и добавления в него элементов из символьного представления.
```
public class SumNumber {
public static void main(String[] args) {

        int number = 321;
        int sum = 0;

        String s = String.valueOf(number); // Перевод числа в строковый вид
        char[] numbers = s.toCharArray(); // [3, 2, 1]
        int[] digits = new int[numbers.length]; // Создаем целочисленный массив

        for (int i = 0; i < numbers.length; i++) {
            digits[i] = numbers[i] - '0'; // ASCII: '0' = 48
            sum += digits[i];
        }
        System.out.println(sum);
    }
}
```

**Решение №2:**

Реализовано засчёт суммирования остатка от деления и уменьшения числа на 1 символ после каждого прохождения цикла while

```
public class SumofNumber {
    public static int SumOfDigits(int number) {
        int n = number;
        int sum = 0;
        while (n > 0) {
            sum += n % 10; // Находим остаток от деления
            n /= 10; // Убираем последний элемент
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfDigits(123);
        System.out.println(result);
    }
}
```