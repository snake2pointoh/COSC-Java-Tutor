package src.week10;

public class Cat extends Animal{

    public Cat(double speed) {
        super(AnimalType.CAT);
        this.speed = speed;
    }

    @Override
    public String sound() {
        return "Meow";
    }

    @Override
    public Object myClone() {
        Cat clone = new Cat(this.speed);
        return clone;
    }
}
