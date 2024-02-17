package src.week17;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowSyncroized {
    public static void main(String[] args) {
        BaseAccount accNonSync = new BaseAccount(123);
        AsyncAccount accSync = new AsyncAccount(123);

        ExecutorService exec = Executors.newFixedThreadPool(6);

        Runnable threadMethodDeposit = () -> {
            for (int i = 0; i < 100; i++) {
//                System.out.println("deposit");
                synchronized (accNonSync) {
                    accNonSync.deposit(10);
                }
            }
        };

        Runnable threadMethodWithdraw = () -> {
            for (int i = 0; i < 100; i++) {
//                System.out.println("withdraw");
                synchronized (accNonSync) {
                    accNonSync.withdraw(10);
                }
            }
        };

        Runnable threadSyncDeposit = () -> {
            for (int i = 0; i < 100; i++) {
                accSync.deposit(10);
            }
        };

        Runnable threadSyncWithdraw = () -> {
            for (int i = 0; i < 100; i++) {
                accSync.withdraw(10);
            }
        };

        exec.execute(threadMethodDeposit);
        exec.execute(threadMethodDeposit);
        exec.execute(threadMethodDeposit);
        exec.execute(threadMethodWithdraw);
        exec.execute(threadMethodWithdraw);
        exec.execute(threadMethodWithdraw);

//        exec.execute(threadSyncDeposit);
//        exec.execute(threadSyncDeposit);
//        exec.execute(threadSyncDeposit);
//        exec.execute(threadSyncWithdraw);
//        exec.execute(threadSyncWithdraw);
//        exec.execute(threadSyncWithdraw);

        exec.shutdown();
        while (!exec.isTerminated()) ;

        System.out.println(accNonSync.getBalance());
//        System.out.println(accSync.getBalance());

    }
}
