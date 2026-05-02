package se.kth.iv1350.repairbike.startup;

import se.kth.iv1350.repairbike.integration.CustomerRegistry;
import se.kth.iv1350.repairbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairbike.controller.Controller;
import se.kth.iv1350.repairbike.view.View;

/**
 * Startar hela applikationen och kopplar ihop lagren.
 */
public class Main {
    public static void main(String[] args) {
        // Initierar integrationslagret (simulerade databaser)
        CustomerRegistry customerRegistry = new CustomerRegistry();
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        
        // Skapar kontrollern och injicerar beroenden
        Controller controller = new Controller(customerRegistry, repairOrderRegistry);
        
        // Startar användargränssnittet
        View view = new View(controller);
        view.run();
    }
}