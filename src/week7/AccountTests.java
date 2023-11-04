package src.week7;

public class AccountTests {
    public static void main(String[] args) {
        Account testAccount = new Account(1, 200.00, "Bryce");

        System.out.println(testAccount.getBalance());

        testAccount.depositMoney(300.00);

        System.out.println(testAccount.getBalance());

        System.out.println(testAccount.depositMoney(-10));

        System.out.println(testAccount.getBalance());

        testAccount.withdrawMoney(25.0);

        System.out.println(testAccount.getBalance());

        testAccount.withdrawMoney(-25.0);

        System.out.println(testAccount.getBalance());

        System.out.println(testAccount.getAccountNumber());
        System.out.println(testAccount.getOwner());
    }
}
