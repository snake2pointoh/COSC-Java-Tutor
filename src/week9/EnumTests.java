package src.week9;

public class EnumTests {
    public static void main(String[] args) {
        Colors myColor = Colors.GREEN;

        System.out.println(myColor.red);
        System.out.println(myColor.green);
        System.out.println(myColor.blue);

        switch (myColor) {
            case RED:
                System.out.println("Red");
                break;
            case GREEN:
                System.out.println("Green");
                break;
            case BLUE:
                System.out.println("Blue");
                break;
        }
    }
}
