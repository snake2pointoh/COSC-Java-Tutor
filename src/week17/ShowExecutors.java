package src.week17;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowExecutors {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.execute(new MyRunnable("t1"));
        executor.execute(new MyRunnable("t2"));
        executor.execute(new MyRunnable("t3"));
        executor.execute(new MyRunnable("t4"));
        executor.execute(new MyRunnable("t5"));

        executor.shutdown();

        System.out.println(executor.isShutdown());

        while(!executor.isTerminated());

        System.out.println("service is shutdown");

    }
}
