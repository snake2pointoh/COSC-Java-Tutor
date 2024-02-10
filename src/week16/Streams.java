package src.week16;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        ArrayList<Integer> aList = new ArrayList<>();

        List<String> names = List.of("Bryce", "Ben", "Donovyn", "Ernesto", "Coralee");

        for (int i = 20; i > 0; i--) {
            aList.add(i);
        }


        Map<Character, Long> myMap = names.stream()
                .collect(Collectors.groupingBy( (x)->(x.charAt(0)), Collectors.counting() ));

//        myMap.forEach((k,v)->{
//            System.out.printf("%s %d\n", k, v);
//        });

        ArrayList<Integer> filterList = aList.stream()
                .filter((x)->x>5)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Integer> filter2List = aList.stream()
                .filter((x)->x%2==0)
                .toList();

        filterList.forEach(System.out::println);
        System.out.println();
        filter2List.forEach(System.out::println);

    }
}
