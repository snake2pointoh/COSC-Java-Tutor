package src.week1;

public class PrintFormatting {
    public static void main(String[] args) {

        //example values
        int number = 10;
        double dNum = 2.5555;
        boolean isTrue = true;
        String sName = "nick";
        char cVal = 'A';

        System.out.println("my name is " + sName);
        //formatting output with printf

        // string format
        System.out.printf("my name is %s\n", sName);

        // string and digit
        System.out.printf("\n%s has %d dollars\n", sName, number);

        // two strings with a tab in-between
        System.out.printf("%s\t%s\n", sName, sName);

        // string and escaping a backslash
        System.out.printf("\"%s\" \\ \n", sName);

        // rounded float/double format
        System.out.printf("my double is: %.2f", dNum);
    }
}
