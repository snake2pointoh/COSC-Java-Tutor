package src.week2;

public class SwitchWithStrings {
    public static void main(String[] args) {
        String sVal = "test";
        switch (sVal) {
            case "test": {
                System.out.println("this was a test");
                break;
            }
            default: {
                System.out.println("this was not a test");
                break;
            }
        }
    }
}
