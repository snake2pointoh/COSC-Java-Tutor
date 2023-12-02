package src.week10;

public class TestAnimal {
    public static void main(String[] args) {
        Dog myDog = new Dog(10);
        Cat myCat = new Cat(8);
        Bird myBird = new Bird(20);

        System.out.println(myDog.getLegCount());
        System.out.println(myCat.getLegCount());
        System.out.println(myBird.getLegCount());

        System.out.println(myDog.compareTo(myBird));

    }
}
