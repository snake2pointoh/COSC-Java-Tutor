package src.week17;

public class BaseAccount {
    private double balance;

    BaseAccount(double initBalance) {
        this.balance = initBalance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value;
    }

    public double getBalance() {
        return balance;
    }
}
