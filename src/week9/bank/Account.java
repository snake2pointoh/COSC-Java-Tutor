package src.week9.bank;

import src.week9.people.Person;

public class Account {
    private Person owner;
    protected double balance;

    public Account(Person owner){
        this.owner = owner;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void withdrawBalance(double value) {
        balance -= value;
    }

    public void depositBalance(double value) {
        balance += value;
    }

    @Override
    public String toString() {
        return String.format("Owner: %s, Balance $%.2f", owner.getName(), balance);
    }
}
