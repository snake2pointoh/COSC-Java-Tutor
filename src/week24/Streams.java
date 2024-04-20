package src.week24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();

        Random random = new Random(12);
        for (int i = 0; i < 100; i++) {
            arrList.add(random.nextInt());
        }

        Iterator<Integer> iterator = arrList.iterator();

        while (iterator.hasNext()) {
            Integer val = iterator.next();

            System.out.println(val);
        }

//        arrList.stream().forEach(System.out::println);

        long count = arrList.stream().filter((x) -> {
            return x > 0;
        }).count();

//        System.out.println(count);

        ArrayList<String> zOrMore = arrList.stream().sorted((x, y) -> {
            return y - x;
        }).map((val) -> {
            if (val < 0) {
                return "Zero";
            }

            return "" + val;
        }).collect(Collectors.toCollection(ArrayList::new));

//        zOrMore.forEach(System.out::println);
    }
}
