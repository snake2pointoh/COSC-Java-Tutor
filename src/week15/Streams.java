package src.week15;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            intList.add(i);
        }

        ArrayList<String> intVals = intList.stream()
                .filter(x -> x > 12)
                .map(x -> ""+x)
                .collect(Collectors.toCollection(ArrayList::new));

        for (String intVal: intVals ) {
            System.out.println(intVal);
        }

        System.out.println();

        intList.stream()
                .filter(x -> x > 12)
                .map(x -> ""+x)
                .forEach(System.out::println);

    }
}
