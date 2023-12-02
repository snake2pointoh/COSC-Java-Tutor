package src.week10;

public class VehicleTests {
    public static void main(String[] args) {
        Sedan mySedan = new Sedan();
        Vehicle myVehicle = new Sedan();
        Truck myTruck = new Truck();

//        mySedan.describeVehicle();
//        mySedan.numberOfSeats();
//
//        myVehicle.describeVehicle();

//        if(myVehicle instanceof Sedan) {
//            System.out.println("Instance Check");
//            Sedan temp = (Sedan) myVehicle;
//            System.out.println(temp.numberOfSeats());
//        }
//
//        if(myVehicle.getType() == VehicleType.SEDAN) {
//            System.out.println("Enum Check");
//            Sedan temp = (Sedan) myVehicle;
//            System.out.println(temp.numberOfSeats());
//        }

        switch (myVehicle.getType()) {
            case SEDAN:
                System.out.println("Enum Check");
                Sedan temp = (Sedan) myVehicle;
                System.out.println(temp.numberOfSeats());
                break;
            case TRUCK:
                break;
            case HATCHBACK:
                break;
        }

        int compareValue = mySedan.compareTo(myTruck);
        if(compareValue > 0) {
            System.out.println("Sedan is greater than Truck");
        }
        if(compareValue == 0) {
            System.out.println("Sedan is the same as Truck");
        }
        if(compareValue < 0) {
            System.out.println("Sedan is less than Truck");
        }

    }
}
