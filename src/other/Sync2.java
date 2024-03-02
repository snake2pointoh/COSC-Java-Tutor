package MyThreads;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sync2
{

    private static ArrayList<Integer> lstVals  = new ArrayList<>();
    private static Integer valToAdd = 0;


    public static  void main(String[] args)
    {
        ExecutorService obPool = Executors.newCachedThreadPool();

        for (int i=0; i< 100; i++)
        {
            obPool.execute(new Runnable()
            {
                @Override
                public synchronized void run()
                {
                    valToAdd++;
                    lstVals.add(valToAdd);

                }
            });

        }

        obPool.shutdown();
        while (!obPool.isTerminated()) ;

        System.out.printf("Value is now %d\n", valToAdd);
        System.out.printf("There are %d elements in the array list \n", lstVals.size());



    }

}
