package src.week10;

public class Bird extends Animal {

    public Bird(double speed) {
        super(AnimalType.BIRD);
        this.speed = speed;
    }

    @Override
    public String sound() {
        return "Chirp";
    }

    @Override
    public Object myClone() {
        Bird clone = new Bird(this.speed);
        return clone;
    }
}
