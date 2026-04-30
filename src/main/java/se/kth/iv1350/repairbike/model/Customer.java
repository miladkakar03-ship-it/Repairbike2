package se.kth.iv1350.repairbike.model; // Modell-lagret

public class Customer { // Klass för att lagra kundinformation
    private String name; // Kundens fullständiga namn
    private String phoneNumber; // Telefonnummer (används för sökning i Bild 1)
    private String email; // Kundens e-postadress
    private Bike bike; // Koppling till kundens cykel (används i Bild 3)

    public Customer(String name, String phoneNumber, String email, Bike bike) { // Konstruktor
        this.name = name; // Initierar namn
        this.phoneNumber = phoneNumber; // Initierar telefonnummer
        this.email = email; // Initierar e-post
        this.bike = bike; // Initierar cykeln
    } // Slut på konstruktor

    public String getPhoneNumber() { // Bild 1, Index 1.1.1: Metod för att hämta numret
        return phoneNumber; // Returnerar telefonnumret till anroparen
    } // Slut på metoden

    public Bike getBike() { // Bild 3, Index 1.1.1: Metod för att hämta cykeln
        return bike; // Returnerar cykel-objektet till orderregistret
    } // Slut på metoden

    public String getName() { return name; } // Getter för namnet (behövs för DTO)
    public String getEmail() { return email; } // Getter för e-posten
} // Slut på klassen