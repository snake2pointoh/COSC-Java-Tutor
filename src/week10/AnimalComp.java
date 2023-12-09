package src.week10;

import java.util.Comparator;

public class AnimalComp implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
//        return o1.compareTo(o2); // accenting order
//        return o2.compareTo(o1); // descending order
        return o1.getLegCount() - o2.getLegCount();
    }
}
