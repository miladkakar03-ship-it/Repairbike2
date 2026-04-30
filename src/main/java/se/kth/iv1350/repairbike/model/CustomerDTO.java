package se.kth.iv1350.repairbike.model; // Modell-lagret

public class CustomerDTO { // Dataöverföringsobjekt för kund
    private final String name; // Oföränderligt namn
    private final String phoneNumber; // Oföränderligt nummer

    public CustomerDTO(Customer customer) { // Konstruktor som kopierar data
        this.name = customer.getName(); // Hämtar namn från det riktiga objektet
        this.phoneNumber = customer.getPhoneNumber(); // Hämtar nummer
    } // Slut på konstruktor

    public String getName() { return name; } // Getter för vyn
    public String getPhoneNumber() { return phoneNumber; } // Getter för kontrollern
} // Slut på klassen