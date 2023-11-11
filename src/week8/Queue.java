package src.week8;

public class Queue {
    private String[] queueArr;

    public Queue(int queueSize) {
        queueArr = new String[queueSize];
    }

    //enqueue
    public boolean Enqueue(String value) {
        // search the array for the first null
        for (int i = 0; i < queueArr.length; i++) {
            if(queueArr[i] == null) {
                //put the item there
                queueArr[i] = value;
                return true;
            }
        }

        return false;
    }

    //dequeue
    public String Dequeue() {
        // get first element
        String returnValue = queueArr[0];

        // shift the whole array up one
        for (int i = 1; i < queueArr.length; i++) {
            queueArr[i-1] = queueArr[i];
        }
        queueArr[queueArr.length-1] = null;

        return returnValue;
    }

    public int Count() {
        for (int i = 0; i < queueArr.length; i++) {
            if(queueArr[i] == null) {
                return i;
            }
        }

        return queueArr.length;
    }
}
