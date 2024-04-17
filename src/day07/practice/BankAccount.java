package day07.practice;

public class BankAccount {
    private String accountHolder;
    private long balance;
    private String  accountNumber;

    public BankAccount (String accountNumber, String accountHolder, long balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) {
        if(money > balance) {
            System.out.println("잔액이 부족합니다.");
        } else {
            balance -= money;
        }
    }
}
