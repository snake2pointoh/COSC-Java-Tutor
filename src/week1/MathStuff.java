package src.week1;

import java.util.Random;

public class MathStuff {
    public static void main(String[] args) {
//        10^2
        double nResult = Math.pow(10,2); // 100

        System.out.println(nResult);

        System.out.println(Math.max(10,20)); // 20

        // same as the math.max method
        int nVal1 = 10;
        int nVal2 = 20;

        if(nVal1 > nVal2){
            System.out.println(nVal1);
        }
        else {
            System.out.println(nVal2);
        }

//        Math.pow(10,2)
//        Math.min(10,20) returns smaller value : 10
//        Math.ceil(); rounds the value UP to the nearest whole number
        System.out.println(Math.ceil(2.1)); // 3.0
//        Math.floor(); rounds the value DOWN to the nearest whole number
        System.out.println(Math.floor(2.1)); // 2.0

        System.out.println(Math.round(2.1)); // 2
        System.out.println(Math.round(2.5)); // 3

        //random numbers
//        Math.random() // 0 and not 1, 0.9999999999999999999999999999999999999999
        int myRandom = (int)(Math.random() * 10) + 1; // 0 and 9
        System.out.println("\nRandom: "+ myRandom);

        Random random = new Random(2);
        System.out.println("\nseeded random: " + random.nextInt(10));


//        Math.abs(-2);   // 2
//        Math.abs(2);    // 2

    }
}
