package src.week7;

public class Account {
    private int accountNumber;
    private double balance;
    private String ownerName;

    public Account(int accNumber, double balance, String ownerName) {
        this.accountNumber = accNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    // deposit money / cant deposit -1
    public boolean depositMoney(double value) {
        if(value > 0) {
            this.balance += value;
            return true;
        }

        return false;
    }

    // withdraw money
    public boolean withdrawMoney(double value) {
        if(this.balance >= value && value > 0) {
            this.balance -= value;
            return true;
        }

        // error not enough money in account
        return false;
    }

    // see how much money you have
    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int value) {
        accountNumber = value;
    }

    public String getOwner() {
        return this.ownerName;
    }

}
