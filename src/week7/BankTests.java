package src.week7;

public class BankTests {
    public static void main(String[] args) {
        Bank testBank = new Bank("CST Bank");

        testBank.createAccount(new Account(0, 500, "Bryce"));
        testBank.createAccount(new Account(0, 250, "Ben"));
        testBank.createAccount(new Account(0, 1500, "Donovyn"));

        Account BryceAccount = testBank.getAccountByID(1);
        System.out.println(BryceAccount.getOwner());
        System.out.println(BryceAccount.getBalance());
        System.out.println();

        testBank.depositIntoAccountByID(1,60.0);

        System.out.println(BryceAccount.getBalance());

        testBank.withdrawFromAccountByID(1,20.0);

        System.out.println(BryceAccount.getBalance());

        System.out.println();

        String[] owners = testBank.getAccountOwners();

        for (String owner : owners) {
            System.out.println(owner);
        }


    }
}
