package src.week10;

public abstract class Vehicle implements Comparable{
    protected int numberOfTires;
    protected int numberOfDoors;

    private VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public abstract String describeVehicle();

    public VehicleType getType() {
        return type;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }
}
