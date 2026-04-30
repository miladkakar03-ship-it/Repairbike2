package se.kth.iv1350.repairbike.model; // Modell-lagret

public class RepairTask { // Representerar ett specifikt jobb som ska göras
    private String description; // Vad som ska göras (t.ex. "Byta däck")
    private double cost; // Vad just detta moment kostar

    public RepairTask(String description, double cost) { // Bild 6, Index 1.1.1: Konstruktor
        this.description = description; // Sparar beskrivningen av jobbet
        this.cost = cost; // Sparar kostnaden för jobbet
    } // Slut på konstruktorn
} // Slut på klassen