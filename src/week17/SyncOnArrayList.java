package src.week17;

import java.util.ArrayList;

public class SyncOnArrayList {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        Thread t1 = new Thread(new AListAccess("T1", myList));
        Thread t2 = new Thread(new AListAccess("T2", myList));
        Thread t3 = new Thread(new AListAccess("T3", myList));
        Thread t4 = new Thread(new AListAccess("T4", myList));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        myList.forEach(System.out::println);
        System.out.println(myList.size());

    }
}
