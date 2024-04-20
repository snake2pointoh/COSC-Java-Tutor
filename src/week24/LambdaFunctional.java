package src.week24;

import java.util.function.Consumer;

public class LambdaFunctional {

    public static void main(String[] args) {

        Consumer<Integer> consume = LambdaFunctional::consumer; // kinda dumb
        Consumer<Integer> consume2 = (x) -> {
            System.out.printf("My value * 2 is: %d\n", x * 2);
        };

//        consumer(12);
//        consume.accept(13);
//        consume2.accept(14);

        doThing(10, LambdaFunctional::consumer);
        doThing(10, consume2);
        doThing(10, (x) -> {
            System.out.printf("My value * 3 is: %d", x * 3);
        });
    }

    public static void doThing(int val, Consumer<Integer> consumer) {
        consumer.accept(val);
    }

    public static void consumer(int val) {
        System.out.printf("My value is: %d\n", val);
    }

}
