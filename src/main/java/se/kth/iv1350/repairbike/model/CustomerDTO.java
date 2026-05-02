package se.kth.iv1350.repairbike.model;

/**
 * En oföränderlig databärare för kundinformation. 
 * Används för att skicka data mellan lager utan att exponera domänobjektet.
 */
public class CustomerDTO {
    private final String name;
    private final String phoneNumber;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.phoneNumber = customer.getPhoneNumber();
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
}