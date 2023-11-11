package src.week8;

public class WrapperClasses {
    public static void main(String[] args) {
        Stack testSack = new Stack(10);

//        System.out.println(testSack.Count());
//
//        testSack.Push("Bob");
//        System.out.println(testSack.Count());
//
//        System.out.println(testSack.Peek());
//        System.out.println(testSack.Count());
//
//        System.out.println(testSack.Pop());
//        System.out.println(testSack.Count());
//
//        System.out.println();
//
        testSack.Push("Bob");
        testSack.Push("Nick");
        testSack.Push("Cade");

        System.out.println(testSack.Pop());
        System.out.println(testSack.Pop());
        System.out.println(testSack.Pop());

        System.out.println();

        Queue testQueue = new Queue(10);

        testQueue.Enqueue("Bob");
        testQueue.Enqueue("Nick");
        testQueue.Enqueue("Cade");

        System.out.println(testQueue.Dequeue());
        System.out.println(testQueue.Dequeue());
        System.out.println(testQueue.Dequeue());
    }
}
