package src.week15;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestPred {
    public static void main(String[] args) {
        Predicate<Double> myPred = (x) -> x == 5.2;

        BiPredicate<Double, Double> myBiPred = (x,y) -> x > y;

        System.out.println( myPred.test(5.2) );
        System.out.println( myPred.test(5.1) );

        System.out.println();

        System.out.println( myBiPred.test(5.2, 5.1) );
        System.out.println( myBiPred.test(5.1, 5.2) );
    }
}
