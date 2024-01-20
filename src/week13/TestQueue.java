package src.week13;

import java.util.ArrayList;

public class TestQueue {
    public static void main(String[] args) {
        GenericQueue<Double> MyQueue = new GenericQueue();

        MyQueue.enqueue(10.2);
        MyQueue.enqueue(4.5);
        MyQueue.enqueue(24.1);
        MyQueue.enqueue(8.6);
        MyQueue.enqueue(275.0);
        MyQueue.enqueue(1.0);

//        Double out = MyQueue.dequeue();
//
//        System.out.println(out);

        System.out.println(MyQueue.dequeue());
        System.out.println(MyQueue.dequeue());
        System.out.println(MyQueue.dequeue());
        System.out.println(MyQueue.dequeue());
        System.out.println(MyQueue.dequeue());
        System.out.println(MyQueue.dequeue());

    }
}
