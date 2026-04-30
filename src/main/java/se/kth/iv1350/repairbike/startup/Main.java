package se.kth.iv1350.repairbike.startup; // Definierar paketet för uppstartsklassen

import se.kth.iv1350.repairbike.integration.CustomerRegistry; // Importerar kundregistret från integrationslagret
import se.kth.iv1350.repairbike.integration.RepairOrderRegistry; // Importerar orderregistret från integrationslagret
import se.kth.iv1350.repairbike.controller.Controller; // Importerar kontrollern
import se.kth.iv1350.repairbike.view.View; // Importerar vyn

/**
 * Innehåller programmets main-metod och ansvarar för att starta hela systemet. [cite: 124, 171]
 */
public class Main {

    /**
     * Startar applikationen genom att skapa nödvändiga objekt. 
     * * @param args Applikationen tar inga kommandoradsargument.
     */
    public static void main(String[] args) {
        // Bild 9, Index 1: Skapar instans av CustomerRegistry i integrationslagret
        CustomerRegistry customerRegistry = new CustomerRegistry();
        
        // Bild 9, Index 2: Skapar instans av RepairOrderRegistry i integrationslagret
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        
        // Bild 9, Index 3: Skapar kontrollern och skickar in de två registren som beroenden
        Controller controller = new Controller(customerRegistry, repairOrderRegistry);
        
        // Bild 9, Index 4: Skapar vyn och ger den tillgång till kontrollern
        View view = new View(controller);
        
        // Bild 9, Index 5: Startar vy-lagret för att simulera interaktion med användaren
        view.run();
    }
}