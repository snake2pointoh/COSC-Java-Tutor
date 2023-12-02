package src.week10;

public class Truck extends Vehicle {
     public Truck() {
         super(VehicleType.TRUCK);

         this.numberOfDoors = 2;
         this.numberOfTires = 4;
     }

    @Override
    public String describeVehicle() {
        return String.format("This is a Truck, it has %d doors and %d wheels", numberOfDoors, numberOfTires);
    }

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
