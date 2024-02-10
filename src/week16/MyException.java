package src.week16;

public class MyException extends Exception {

    public MyException() {
        this("Default Message");
    }

    public MyException(String message) {
        super(message);
    }
}
