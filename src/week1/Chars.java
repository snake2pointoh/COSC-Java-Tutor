package src.week1;

public class Chars {
    public static void main(String[] args) {
        // Convert char value into an int ASCII value
        char cChar1 = 'A';
        int nAsciiVal1 = cChar1;

        System.out.println("char to int ASCII:");
        System.out.printf("char value: %c, ASCII value: %d\n", cChar1, nAsciiVal1);

        cChar1 += 1;
        nAsciiVal1 = cChar1;

        System.out.printf("char value: %c, ASCII value: %d\n", cChar1, nAsciiVal1);

        // Convert int ASCII value into a char
        System.out.println("\nint to char ASCII:");
        int nAsciiVal2 = 48;
        char cChar2 = (char)nAsciiVal2;
        System.out.printf("ASCII value: %d, char value: %c\n", nAsciiVal2, cChar2);

        nAsciiVal2++;
        cChar2 = (char)nAsciiVal2;
        System.out.printf("ASCII value: %d, char value: %c\n", nAsciiVal2, cChar2);

    }
}
