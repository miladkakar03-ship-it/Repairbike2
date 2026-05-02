package se.kth.iv1350.repairbike.model;

/**
 * Innehåller information om kunden och kopplingen till kundens cykel.
 */
public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private Bike bike;

    public Customer(String name, String phoneNumber, String email, Bike bike) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bike = bike;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public Bike getBike() { return bike; }
}