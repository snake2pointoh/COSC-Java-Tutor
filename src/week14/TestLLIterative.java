package src.week14;

public class TestLLIterative {
    public static void main(String[] args) {
        LinkedListIterative<Integer> myLLI = new LinkedListIterative<>();

        myLLI.add(10);
        myLLI.add(11);
        myLLI.add(12);
        myLLI.add(13);

        myLLI.remove(12);
    }
}
