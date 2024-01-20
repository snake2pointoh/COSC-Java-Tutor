package src.week13;

import src.week10.AnimalType;
import src.week10.MyCloneable;

public abstract class Animal implements Comparable<Animal>, MyCloneable {
    protected double speed;
    private AnimalType type;

    public Animal(AnimalType type) {
        this.type = type;
    }

    public abstract String sound();

    // (int) getter for the number of legs of this animal
    public int getLegCount() {
        return type.LEGS;
    }

    public AnimalType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("Speed: %.2f, Legs: %d", speed, this.getLegCount());
    }

    @Override
    public int compareTo(Animal other) {
        return (int) ( this.speed - other.speed );
    }

    public boolean equals(Animal obj) {
        if(this.compareTo(obj) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
