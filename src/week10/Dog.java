package src.week10;

public class Dog extends Animal {

    public Dog(double speed) {
        super(AnimalType.DOG);
        this.speed = speed;
    }

    @Override
    public String sound() {
        return "Wof";
    }

    @Override
    public Object myClone() {
        Dog clone = new Dog(this.speed);
        return clone;
    }
}
