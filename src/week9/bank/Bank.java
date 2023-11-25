package src.week9.bank;

public class Bank {
    private Account[] accounts;
    private String name;

    public Bank(String name) {
        this.accounts = new Account[10];
        this.name = name;
    }

    public void addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] == null) {
                accounts[i] = account;
                break;
            }
        }
    }

    public void applyInterest() {
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] == null) {
                break;
            }
            if(accounts[i] instanceof SavingsAccount) {
                SavingsAccount temp = (SavingsAccount) accounts[i];
                temp.doInterest();
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String output = "";

        for (Account acc: accounts) {
            if(acc == null) {
                break;
            }

            if(acc instanceof SavingsAccount) {
                output += "Savings: " + acc.toString() + "\n";
            } else {
                output += "Account: " + acc.toString() + "\n";
            }
        }

        return output;
    }
}
