package se.kth.iv1350.repairbike.integration; // Anger paketet för integrationslagret

import java.util.ArrayList; // Importerar ArrayList för att kunna lagra flera kunder
import java.util.List; // Importerar List-interfacet
import se.kth.iv1350.repairbike.model.Bike; // Importerar Bike för att kunna skapa testdata
import se.kth.iv1350.repairbike.model.Customer; // Importerar Customer för att hantera kundobjekt

/**
 * Denna klass simulerar en databas med kunder.
 * Den ansvarar för att söka fram befintliga kunder i systemet.
 */
public class CustomerRegistry { // Start på klassen CustomerRegistry
    private List<Customer> customers = new ArrayList<>(); // Attribut: En lista som fungerar som kunddatabas

    /**
     * Konstruktor som initierar registret med testdata.
     */
    public CustomerRegistry() { // Konstruktor
        // Skapar en cykel för att kunden ska ha något att lämna in (behövs för Bild 3)
        Bike testBike = new Bike("Yosemite", "Electric S1", "SN12345"); 
        
        // Lägger till en testkund i listan så att sökningen i Bild 1 fungerar
        customers.add(new Customer("Sven Svensson", "0701112233", "sven@kth.se", testBike)); 
    } // Slut på konstruktorn

    /**
     * Bild 1, Index 1.1: Söker efter en kund baserat på telefonnummer.
     * @param phoneNumber Telefonnumret som receptionisten skriver in.
     * @return Customer-objektet om det hittas, annars null.
     */
    public Customer findCustomer(String phoneNumber) { // Metod för att hitta kund
        for (Customer customer : customers) { // Loopar igenom alla kunder i registret
            // Bild 1, Index 1.1.1: Anropar getPhoneNumber på kunden för att jämföra
            if (customer.getPhoneNumber().equals(phoneNumber)) { 
                return customer; // Returnerar kunden om numret matchar sökningen
            } // Slut på if
        } // Slut på for-loopen
        return null; // Returnerar null om ingen kund med det numret hittades
    } // Slut på metoden findCustomer
} // Slut på klassen CustomerRegistry