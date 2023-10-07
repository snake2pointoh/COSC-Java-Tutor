package src.week3;

import java.util.Scanner;

public class maxNumberOccurance {
    public static void main(String[] args) {
        Scanner obin = new Scanner(System.in);

        int input = obin.nextInt();

        int largestNumber = 0;
        int count = 0;

        while (input > 0)
        {
            if(max(input, largestNumber) > largestNumber)
            {
                largestNumber = input;
                count = 1;
            }
            else if (input == largestNumber)
            {
                count++;
            }

            input = obin.nextInt();
        }

        System.out.printf("Largest number was: %d, it was inputted %d times", largestNumber, count);

    }

    public static int max(int n1, int n2)
    {
        if(n1 > n2) {
            return n1;
        }

        return n2;
    }
}
