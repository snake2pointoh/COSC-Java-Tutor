package src.week7;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();

        Person p2 = new Person("bill");

        Person p3 = new Person("bob",14);

//        System.out.println(p3.getName());

        System.out.println(p3.drinkingAge());
        System.out.println(Person.drinkingAge());


    }
}
