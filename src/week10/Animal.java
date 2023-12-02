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

    @Override
    public int compareTo(Object o) {
        if(o instanceof Animal) {
            Animal other = (Animal) o;
            return (int) ( this.speed - other.speed );
        }

        // usually throw an error
        return 1;
    }
}
