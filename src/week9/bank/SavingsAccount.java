package src.week9.bank;

import src.week9.people.Person;

public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(Person owner, double interestRate) {
        super(owner);
        this.interestRate = interestRate;
    }

    public void doInterest() {
        double interestValue = this.balance * interestRate;
        this.balance += interestValue;
    }

    @Override
    public String toString() {
        return super.toString() + " Intrest: " + interestRate;
    }
}
