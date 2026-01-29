# 4. Введение в рекурсию

## Что это?
Рекурсия - это когда метод вызывает сам себя для решения подзадач.

**Обязательные части:**

1. **Базовый случай** — условие, при котором рекурсия останавливается
2. **Рекурсивный случай** — когда метод вызывает сам себя

---
### Пример №1: Факториал

```
package ru.week2.day4;

public class rec {
    public static int factorial(int n) {
        
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}

```
Как это работает:
```
factorial(5)
= 5 * factorial(4)
= 5 * (4 * factorial(3))
= 5 * (4 * (3 * factorial(2)))
= 5 * (4 * (3 * (2 * factorial(1))))
= 5 * (4 * (3 * (2 * 1)))
= 120
```
---
### Пример №2: Степень числа

```
package ru.week2.day4;

public class rec {
    public static int power(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2,5));
    }
}
```
Как это работает: 

```
// 2 * (2, 4)
// 2 * 2 * (2, 3)
// 2 * 2 * 2 * (2, 2)
// 2 * 2 * 2 * 2 * (2, 1)
// 2 * 2 * 2 * 2 * 2 * 1 = 32 (2^5)
```

**Важно:** Убедитесь, что всегда будет достигнут базовый случай, иначе возникнет
StackOverflowError!
