package src.week15;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestFunc {
    public static void main(String[] args) {

        Function<Integer, Integer> myIntFunc = (x) -> x / 2;

        // x is of type Integer, y is of type Double, return is of type Integer
        BiFunction<Integer, Double, Integer> myBiFunction = (x , y) -> (int)( x / y );

        System.out.println( myIntFunc.apply(10) );
        System.out.println( myBiFunction.apply(10,5.0) );

        doThingToInt(15, TestFunc::doubleInt);
        doThingToInt(20, new MyFunc());

    }

    public static void doThingToInt(int value, Function<Integer, Integer> func) {
        int newVal = func.apply(value);

        System.out.println(newVal);
    }

    public static Integer doubleInt(Integer value) {
        return value * 2;
    }
}
