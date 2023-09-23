package src.week2;

public class PrintFormatting {
    public static void main(String[] args) {
        System.out.println("println");

        // next line
        System.out.printf("printF\n");
        System.out.printf("printF\n");

        //inset values into the formatted print
        System.out.println("i have " + 3 + " apples");
        System.out.printf("i have %d apples\n", 3);
        // %d ints 1,2, 10, 100
        // %f floats and doubles 1.1 1.2 %.2f
        System.out.printf("i have $%.2f\n", 56.2476);
        // %s strings and chars
        String name = "nick";
        System.out.printf("my name is: %s\n", name);

        // \n \t
        System.out.printf("this is a\ttab\n");

        // multiple values
        System.out.printf("%s has %d dollars", name, 10);
    }
}
