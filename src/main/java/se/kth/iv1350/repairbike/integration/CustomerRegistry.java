package se.kth.iv1350.repairbike.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairbike.model.Bike;
import se.kth.iv1350.repairbike.model.Customer;

/**
 * Simulerar en databas med kunder.
 */
public class CustomerRegistry {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRegistry() {
        // Initierar testdata för att kunna köra scenariot i systemoperation 1
        Bike testBike = new Bike("Yosemite", "Electric S1", "SN12345");
        customers.add(new Customer("User", "12345678", "Usern@gmail.se", testBike));
    }

    public Customer findCustomer(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }
}