package src.week18;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class locks {

    static Lock myLock = new ReentrantLock();

    static Random random = new Random();
    static ArrayList<Integer> myList = new ArrayList<>();

    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool(120 );

        for (int i = 0; i < 100; i++) {
            executor.execute(locks::doThing);
        }

        for (int i = 0; i < 20; i++) {
            executor.execute(locks::doOtherThing);
        }

        executor.shutdown();

        while(!executor.isTerminated());

        System.out.println(myList.size());
    }

    public static void doThing() {

        int value = random.nextInt();

        myLock.lock();

        myList.add(value);

        myLock.unlock();

    }

    public static void doOtherThing() {

        myLock.lock();

        myList.remove(0);

        myLock.unlock();
    }



}
