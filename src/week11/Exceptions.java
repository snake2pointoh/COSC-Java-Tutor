package src.week11;

public class Exceptions {
    public static void main(String[] args) {
        // Checked VS Unchecked Exceptions
        try {
            System.out.println("Try");
            throw new Exception("Custom Exception Message");

        } catch (Exception e) {
            System.out.println("Catch");
//            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");

        }
    }
}
