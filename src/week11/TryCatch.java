package src.week11;

public class TryCatch {
    public static void main(String[] args) {

        try {
//            int value = 1/0;
            throw new MyException();
        }
        catch (MyException e) {
            System.out.println("Checked Exception");
            e.printStackTrace();

        }
        finally {
            System.out.println("Finally");

        }
        System.out.println("After");

    }
}
