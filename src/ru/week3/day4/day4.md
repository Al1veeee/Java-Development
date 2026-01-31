### Тема 3: Переменные Экземпляра (Instance Variables)

**Что это?**
Переменные экземпляра — это переменные класса, которые существуют для каждого отдельного объекта.

```java
public class BankAccount {
    String accountHolder;    // Переменная экземпляра
    double balance;          // Переменная экземпляра
    String accountNumber;    // Переменная экземпляра
    
    public BankAccount(String holder, String number) {
        accountHolder = holder;
        accountNumber = number;
        balance = 0.0;
    }
}

BankAccount acc1 = new BankAccount("Alice", "12345");
BankAccount acc2 = new BankAccount("Bob", "67890");

// Каждый объект имеет свои значения переменных экземпляра
acc1.balance = 1000;
acc2.balance = 5000;

System.out.println(acc1.accountHolder); // Output: Alice
System.out.println(acc2.accountHolder); // Output: Bob
System.out.println(acc1.balance);       // Output: 1000.0
System.out.println(acc2.balance);       // Output: 5000.0
```

**Отличие от локальных переменных:**
- **Переменные экземпляра** — существуют в течение всей жизни объекта
- **Локальные переменные** — существуют только внутри метода

```java
public class Example {
    int instanceVar = 10;  // Переменная экземпляра, начальное значение 10
    
    public void method() {
        int localVar = 5;   // Локальная переменная
        System.out.println(instanceVar); // ✓ доступна
        System.out.println(localVar);    // ✓ доступна
    }
}

// localVar не доступна здесь - она перестала существовать после метода
