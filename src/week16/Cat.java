package src.week16;

import java.io.Serializable;

public class Cat implements Serializable {

    public String name;
    public int age;
    public float cost;
    public boolean isMale;

    Cat(String name, int age, float cost, boolean isMale) {
        this.name = name;
        this.age = age;
        this.cost = cost;
        this.isMale = isMale;
    }
}
