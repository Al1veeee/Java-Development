package ru.week3.day4;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;


    public BankAccount(String AccountNumber, String AccountHolder, double Balance){
        this.accountNumber = AccountNumber;
        this.accountHolder = AccountHolder;
        this.balance = Balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {

            System.out.println("Пополнение счёта: ");

            System.out.println("Было: " + balance);
            balance += amount;
            System.out.println("Стало: " + balance);
            this.balance = balance;
        } else {
            System.out.println("Внестите сумму превышающую 0");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount < balance) {

            System.out.println("\nCнятие счёта: ");

            System.out.println("Было: " + balance);
            balance -= amount;
            System.out.println("Стало: " + balance);
            this.balance = balance;
        }
    }
    public void getBalance() {
        System.out.println("\n===Баланс=== " + accountNumber + " / " + accountHolder + "\n" + balance);
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть больше 0");
            return;
        }
        if (amount > balance) {
            System.out.println("Недостаточно средств для перевода");
            return;
        }
        this.balance -= amount;

        otherAccount.balance += amount;
        System.out.println("\nПеревод " + amount + this.accountNumber + " -> " + otherAccount.accountNumber);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("001", "Alice", 1000);
        BankAccount acc2 = new BankAccount("002", "Bob", 500);

        acc1.deposit(500);        // Баланс acc1 = 1500
        acc1.withdraw(200);       // Баланс acc1 = 1300

        acc1.getBalance();
        acc2.getBalance();

        acc1.transfer(acc2, 300);

        acc1.getBalance();
        acc2.getBalance();
    }
}
