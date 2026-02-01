### Тема 4: Методы Экземпляра (Instance Methods)

**Что это?**
Методы экземпляра — это методы, которые работают с данными (переменными экземпляра) конкретного объекта.

```java
public class BankAccount {
    String accountHolder;
    double balance;
    
    public BankAccount(String holder) {
        accountHolder = holder;
        balance = 0.0;
    }
    
    // Методы экземпляра
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Пополнено: " + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Снято: " + amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void displayInfo() {
        System.out.println("Владелец: " + accountHolder);
        System.out.println("Баланс: " + balance);
    }
}

// Использование
BankAccount acc = new BankAccount("Alice");
acc.deposit(1000);        // Пополнено: 1000
acc.withdraw(300);        // Снято: 300
System.out.println(acc.getBalance()); // Output: 700.0
acc.displayInfo();
// Output:
// Владелец: Alice
// Баланс: 700.0
```

**Важно:** Методы экземпляра могут обращаться к переменным экземпляра:

```java
public class Dog {
    String name;
    int age;
    
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void bark() {
        // Можно обращаться к this.name и this.age
        System.out.println(this.name + " говорит: Гав!");
    }
}

Dog dog = new Dog("Rex", 5);
dog.bark(); // Output: Rex говорит: Гав!
