package src.week14;

import java.util.ArrayList;

import static src.week14.RecMethods.*;

public class TestRecMethods {
    public static void main(String[] args) {
//        System.out.println(recRoundRobin(4));
//
//        ArrayList<Integer> fibList = calcFib(20);
//
//        for (Integer val: fibList) {
//            System.out.println(val);
//        }

        int numWords = recCountWord("CST is so so so fun", "so"); // 2
        System.out.println(numWords);

        int sumDigits = recSumDigits(246); // 12
        System.out.println(sumDigits);

    }
}
