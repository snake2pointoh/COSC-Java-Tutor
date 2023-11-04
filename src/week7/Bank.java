package src.week7;

public class Bank {
    private String name;
    private Account[] accounts;
    private int numberOfAccounts;
    private static final int ACCOUNT_GROW_SIZE = 10;

    public Bank(String name) {
        this.name = name;
        this.accounts = new Account[ACCOUNT_GROW_SIZE];
        this.numberOfAccounts = 0;
    }

    // create new account
    public void createAccount(Account newAccount) {
        for (int i = 0; i < this.accounts.length; i++) {
            if(this.accounts[i] == null) {
                // update the account number to be unique
                numberOfAccounts++;
                newAccount.setAccountNumber(numberOfAccounts);

                this.accounts[i] = newAccount;
                return;
            }
        }

        growAccountArray();
        createAccount(newAccount);
    }

    private void growAccountArray() {
        Account[] newArray = new Account[this.accounts.length + ACCOUNT_GROW_SIZE];
        for (int i = 0; i < this.accounts.length; i++) {
            newArray[i] = this.accounts[i];
        }
        this.accounts = newArray;
    }

    // get an account by account id
    // if the account does not exist return a null
    public Account getAccountByID(int accID) {
        for (int i = 0; i < this.accounts.length; i++) {
            if(this.accounts[i].getAccountNumber() == accID) {
                return this.accounts[i];
            }
            if(this.accounts[i] == null) {
                break;
            }
        }

        return null;
    }

    public boolean depositIntoAccountByID(int accID, double value) {
        // check if the account exits
        Account currentAccount = getAccountByID(accID);
        if(currentAccount == null) {
            return false;
            // ERROR: account does not exits
        }

        // try to deposit the value into the account
        return currentAccount.depositMoney(value);
    }

    public boolean withdrawFromAccountByID(int accID, double value) {
        Account currentAccount = getAccountByID(accID);
        if(currentAccount == null) {
            return false;
        }

        return currentAccount.withdrawMoney(value);
    }

    // get all accounts
    public Account[] getAccounts() {
        return accounts;
    }

    // get bank name
    public String getName() {
        return this.name;
    }

    // get all account owners
    public String[] getAccountOwners() {
        String[] owners = new String[numberOfAccounts];
        for (int i = 0; i < owners.length; i++) {
            owners[i] = this.accounts[i].getOwner();
        }

        return owners;
    }

}
