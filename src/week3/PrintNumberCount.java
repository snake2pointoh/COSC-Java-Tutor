package src.week3;

import java.util.Scanner;

public class PrintNumberCount {
    public static void main(String[] args) {
        Scanner obin = new Scanner(System.in);
        int number = obin.nextInt();

        while (number > 0)
        {
            System.out.printf("the sum of %d digits is %d\n", number, sumDigits(number));
            System.out.printf("the reverse of %d is %d\n", number, reverseDigits(number));
            number = obin.nextInt();
        }

    }

    // make method that print out the sum of the numbers digits that was passed in
    // sumDigits(234) = 2+3+4 = 9
    public static int sumDigits(int number)
    {
        int sumOfDigits = 0;

        // split number into individual digits
        int modValue = 10;
        while (number > 0) {
            int digit = (number % modValue);
            number = number - digit; // 234 -4 = 230, 230 - 30 = 200
            digit = digit / (modValue / 10);

            modValue = modValue * 10;
            // add the digits together
            sumOfDigits += digit;
        }

        // return the sum of all the digits
        return sumOfDigits;
    }

    // reverse digits method
    // Ex: 234 -> 432  4 -> 400, 30 -> 30, 200 -> 2
    public static int reverseDigits(int number)
    {
        int reversedNumber = 0;

        int modValue = 10;
        while(number > 0)
        {
            int digit = (number % modValue);
            number = number - digit;
            digit = digit / (modValue/10);

            modValue = modValue * 10;

            // 4 ,3 ,2
            reversedNumber += digit; // 4
            reversedNumber *= 10; // 40

        } // 4320

        reversedNumber = reversedNumber/10;

        return  reversedNumber;
    }
}
