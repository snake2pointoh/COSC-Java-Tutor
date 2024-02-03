package src.week15;

public class InternalClass {
    public String name;

    private Address address;

    public InternalClass(String name, String city, String street, String postal) {
        this.name = name;
        this.address = new Address(city,street,postal);
    }

    public String getStreet() {
        return address.street;
    }
    public String getCity() {
        return address.city;
    }
    public String getPostal() {
        return address.postal;
    }

    private class Address {
        public String street;
        public String postal;
        public String city;

        public Address(String city, String street, String postal) {
            this.city = city;
            this.street = street;
            this.postal = postal;
        }
    }
}
