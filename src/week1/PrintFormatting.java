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

        System.out.printf("my name is %s\n", sName);

        System.out.printf("\n%s has %d dollars\n", sName, number);

        System.out.printf("%s\t%s\n", sName, sName);

        System.out.printf("\"%s\" \\ \n", sName);

        System.out.printf("my double is: %.2f", dNum);
    }
}
