package src.week9.bank;

import src.week9.people.Person;

public class TestBank {
    public static void main(String[] args) {
        Bank myBank = new Bank("My Bank");

        Account acc1 = new Account(new Person("Bob",23));
        Account acc2 = new Account(new Person("Bill",23));
        SavingsAccount acc3 = new SavingsAccount(new Person("Bob",23), 0.05);
        SavingsAccount acc4 = new SavingsAccount(new Person("Bill",23), 0.2);

        acc1.depositBalance(50);
        acc2.depositBalance(60);
        acc3.depositBalance(70);
        acc4.depositBalance(80);

//        System.out.println(acc1);
//        System.out.println(acc3);

        myBank.addAccount(acc1);
        myBank.addAccount(acc2);
        myBank.addAccount(acc3);
        myBank.addAccount(acc4);

        System.out.println(myBank);

        myBank.applyInterest();

        System.out.println(myBank);

    }
}
