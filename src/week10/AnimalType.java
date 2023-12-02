package src.week10;

public enum AnimalType {
    DOG(4),
    CAT(4),
    BIRD(2);

    public final int LEGS;

    AnimalType(int legCount) {
        this.LEGS = legCount;
    }
}
