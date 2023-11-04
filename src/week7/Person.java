package src.week7;

public class Person {

    public String name;
    private int age;

    public Person() {
        this("",0);
    }

    public Person(String name){
        this(name,0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String val) {
        this.name = val;
    }

    public boolean setAge(int val) {
        if(val >= 0) {
            this.age = val;
            return true;
        }

        return false;

    }

    public static int drinkingAge() {
        return 19;

    }

//    public static Person newPerson() {
//
//    }
}
