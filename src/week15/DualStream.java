package src.week15;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DualStream {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            intList.add(i);
        }

        ArrayList <String> strList = intList.stream()
                .map((x) -> "Value: " + x + ", Elements Before: " +
                    intList.stream().filter(y -> y < x).count())
                .collect(Collectors.toCollection(ArrayList::new));

        strList.forEach(System.out::println);
    }
}
