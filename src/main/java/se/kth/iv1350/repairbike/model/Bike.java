package se.kth.iv1350.repairbike.model; // Definierar paketnamnet för modellen

public class Bike { // Start på klassen som representerar en cykel
    private String brand; // Attribut för cykelns märke (t.ex. Yosemite)
    private String model; // Attribut för cykelns modell (t.ex. Electric S1)
    private String serialNumber; // Attribut för ramnumret (unikt för cykeln)

    public Bike(String brand, String model, String serialNumber) { // Konstruktor för att skapa objektet
        this.brand = brand; // Sparar det inskickade märket i attributet
        this.model = model; // Sparar den inskickade modellen i attributet
        this.serialNumber = serialNumber; // Sparar ramnumret i attributet
    } // Slut på konstruktorn
} // Slut på klassen