package src.week10;

public abstract class Animal implements Comparable, MyCloneable {
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
    public int compareTo(Object o) {
        if(o instanceof Animal) {
            Animal other = (Animal) o;
            return (int) ( this.speed - other.speed );
        }

        // usually throw an error
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Animal) {
            return this.compareTo(obj) == 0;
        } else {
            return false;
        }
    }
}
