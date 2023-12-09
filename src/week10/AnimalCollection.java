package src.week10;

import java.util.ArrayList;
import java.util.Collections;

public class AnimalCollection {
    public static void main(String[] args) {
        ArrayList<Animal> animalArray = new ArrayList<>();

        animalArray.add(new Dog(10));
        animalArray.add(new Cat(12));
        animalArray.add(new Bird(20));
        animalArray.add(new Dog(8));
        animalArray.add(new Cat(12));

        Collections.sort(animalArray, new AnimalComp());

        for ( Animal animal : animalArray) {
            System.out.println(animal);
        }
    }
}
