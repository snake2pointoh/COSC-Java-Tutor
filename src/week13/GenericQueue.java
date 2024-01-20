package src.week13;

public class GenericQueue <T> {

    T[] values;

    // constructor
//    GenericQueue(T[] array) {
//        values = array;
//    }

    GenericQueue() {
        values = (T[]) new Object[10];

    }

    // enqueue // put at the end of the queue
    public void enqueue(T value) throws IllegalArgumentException{
        recEnqueue(value, 0);
    }

    private void recEnqueue(T value, int index) throws IllegalArgumentException {
        if(index >= values.length) {
            throw new IllegalArgumentException("Index out of bounds for Queue");
        }

        if(values[index] == null) {
            values[index] = value;
            return;
        }

        index++;
        recEnqueue(value, index);
    }

    // dequeue // take the item at the start of the queue, shuffle the queue down one, and return the item
    public T dequeue() throws IllegalArgumentException{
        if(values[0] == null) {
            throw new IllegalArgumentException("Queue is empty");
        }

        T returnValue = values[0];

        for (int i = 1; i < values.length; i++) {
            values[i-1] = values[i];

            if(values[i] == null) {
                values[i-1] = null;
            }
        }

        values[values.length - 1] = null;

        return returnValue;
    }
}
