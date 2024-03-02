package src.week18;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class fullEmptySignal {

    private static Lock myLock = new ReentrantLock();

    private static Condition notEmpty = myLock.newCondition();
    private static Condition notFull = myLock.newCondition();

    private static final int CAPACITY = 10;

    private static ArrayList<Integer> myList = new ArrayList<>();

    public static void main(String[] args) {

        ExecutorService executors = Executors.newCachedThreadPool();

        // insert 20 times
        for (int i = 0; i < 20; i++) {
            final int val = i;
            executors.execute(() -> {
                fullEmptySignal.insert(val);
            });
        }

        System.out.println(myList.size());

        for (int i = 0; i < 10; i++) {
            executors.execute(() -> {
                int value = fullEmptySignal.remove();
                System.out.println(value);
            });
        }


        executors.shutdown();
        while (!executors.isTerminated());

        System.out.println(myList.size());

    }

    private static void insert(int value) {
        myLock.lock();
        try {
            while (myList.size() >= CAPACITY ) {
                notFull.await();
            }

            myList.add(value);

            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myLock.unlock();
    }

    private static int remove() {
        int value = 0;
        myLock.lock();

        try {
            while (myList.size() <= 0) {
                notEmpty.await();
            }

            value = myList.remove(0);
            notFull.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myLock.unlock();
        return value;
    }
}
