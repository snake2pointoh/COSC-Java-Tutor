package MyThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sync1
{

    private static Account testAccount = new Account();

    public static void main(String[] args)
    {
        ExecutorService obPool = Executors.newCachedThreadPool();

        for (int i=0; i<100; i++)
        {
            obPool.execute(() -> testAccount.addAPenny());
        }
        obPool.shutdown();

        while (!obPool.isTerminated())  ;

        System.out.printf("Final Balance is %d\n", testAccount.getBalance());

    }

    public static class Account
    {
        int balance;

        public  void addAPenny()
        {
            synchronized (this)
            {
                int nNewBalance = balance + 1;

                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException exp)
                {

                }


                balance = nNewBalance;
            }


            System.out.printf("Trying to add a penny\n");

        }

        public int getBalance()
        {
            return balance;
        }

    }
}
