package src.week17;

public class AsyncAccount extends BaseAccount {
    AsyncAccount(double initBalance) {
        super(initBalance);
    }

    @Override
    public synchronized void deposit(double value) {
        super.deposit(value);
    }

    @Override
    public synchronized void withdraw(double value)  {
        super.withdraw(value);
    }
}
