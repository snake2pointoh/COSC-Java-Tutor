package src.week16;

public class Exceptions {
    public static void main(String[] args) {

        try {
            Checked();
        } catch (MyException e) {
            e.printStackTrace();
        }

        UnChecked();

    }

    public static void Checked() throws MyException {
        throw new MyException();
    }

    public static void UnChecked() throws IllegalArgumentException {
        throw new IllegalArgumentException("Test Unchecked");
    }
}
