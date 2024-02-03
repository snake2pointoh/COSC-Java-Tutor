package src.week15;

import java.util.function.Function;

public class MyFunc implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer * 3;
    }
}
