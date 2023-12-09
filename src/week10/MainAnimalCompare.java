package src.week10;

public class MainAnimalCompare {
    public static void main(String[] args) {
        Animal a1 = new Dog(12.0);
        Animal a2 = new Dog(10.0);

        // compare to
        System.out.println(a1.compareTo(a2));

        if(a1.compareTo(a2) > 0) {
            System.out.println("A1 is bigger!");
        } else {
            System.out.println("A1 is smaller!");
        }

        //equals
        System.out.println(a1.equals(a2));
        System.out.println(a1.compareTo(a2) == 0);

        //comparator
        AnimalComp comp = new AnimalComp();
        System.out.println(comp.compare(a1,a2));
    }
}
