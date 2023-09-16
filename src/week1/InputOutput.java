package src.week1;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);

        System.out.println("please enter your name:");

        String name = obIn.nextLine();
        System.out.printf("Hello %s\n", name);
        //edit name
        //print name again

        System.out.printf("Hello %s\n", obIn.next());
        System.out.printf("and also %s\n", obIn.next());

        double dVal = obIn.nextDouble();
//        double nVal = obIn.nextInt();


        System.out.printf("Double: %f\n", dVal);
        System.out.printf("Int: %d\n", (int)dVal);
    }
}
