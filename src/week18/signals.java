package src.week18;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class signals {

    static Lock myLock = new ReentrantLock();

    static Random random = new Random();
    static ArrayList<Integer> myList = new ArrayList<>();

    static Condition myCondition = myLock.newCondition();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executor.execute(signals::doOtherThing);
            executor.execute(signals::doThing);
        }

        executor.shutdown();

        while(!executor.isTerminated());

        System.out.println(myList.size());
    }

    public static void doThing() {

        int value = random.nextInt();

        myLock.lock();

        myList.add(value);
        value++;
        myList.add(value);
        value++;
        myList.add(value);

        myCondition.signalAll();

        myLock.unlock();

    }

    public static void doOtherThing() {
        try {
            myLock.lock();

            myCondition.await();

            myList.remove(0);

            myLock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
