package MyThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool1
{

    public static void main(String[] args)
    {
        ExecutorService obPool = Executors.newFixedThreadPool(2);

        obPool.execute(() -> printVals('a', 100));
        obPool.execute(() -> printVals('b', 100));
        obPool.execute(() -> printVals('c', 100));
        obPool.execute(() -> printVals('d', 100));


        obPool.shutdown();

        while (!obPool.isTerminated()) ;




        System.out.printf("\nAll Finished\n");


    }


    public static void printVals(char cVal, int nTimes)
    {
        for (int i=0; i< nTimes; i++)
        {
            System.out.print(cVal + " ");

        }
    }
}
