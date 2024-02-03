package src.week15;

import java.util.function.Supplier;

public class TestSupp {
    public static void main(String[] args) {
        Supplier<String> mySupply = () -> "This is supplied";

        System.out.println(mySupply.get());
    }
}
