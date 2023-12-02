package src.week10;

public class Sedan extends Vehicle{

    public Sedan() {
        super(VehicleType.SEDAN);

        this.numberOfDoors = 4;
        this.numberOfTires = 4;
    }

    @Override
    public String describeVehicle() {
        return String.format("This is a Sedan, it has %d doors and %d wheels", numberOfDoors, numberOfTires);
    }

    public int numberOfSeats() {
        return 4;
    }


    // 1 or greater is bigger than other
    // -1 or less is smaller than other
    // 0  is the same

    @Override
    public int compareTo(Object other) {
        if(other instanceof Vehicle) {
            Vehicle oVehicle = (Vehicle) other;

            if(this.numberOfDoors > oVehicle.numberOfDoors) {
                return 1;
            }
            if(this.numberOfDoors < oVehicle.numberOfDoors) {
                return -1;
            }

            return 0;
        }

        // usually throw an error
        return 0;
    }
}
