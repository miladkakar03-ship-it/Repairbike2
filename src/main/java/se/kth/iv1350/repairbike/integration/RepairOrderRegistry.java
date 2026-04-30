package se.kth.iv1350.repairbike.integration; // Samma paket som ovan

import java.util.ArrayList; // Importerar ArrayList för att lagra ordrar
import java.util.List; // Importerar List-interfacet
import se.kth.iv1350.repairbike.model.Bike; // Importerar Bike
import se.kth.iv1350.repairbike.model.Customer; // Importerar Customer
import se.kth.iv1350.repairbike.model.RepairOrder; // Importerar RepairOrder

/**
 * Denna klass simulerar en databas för alla reparationsordrar.
 * Ordrar sparas här och tas aldrig bort.
 */
public class RepairOrderRegistry { // Start på klassen RepairOrderRegistry
    private List<RepairOrder> repairOrders = new ArrayList<>(); // Attribut: Lista som lagrar alla ordrar

    /**
     * Skapar ett tomt register.
     */
    public RepairOrderRegistry() { // Konstruktor
        // Inget behov av startdata för ordrar
    } // Slut på konstruktorn

    /**
     * Bild 3, Index 1.1: Skapar en ny reparationsorder.
     * @param customer Kunden som äger cykeln.
     * @param bike Cykeln som ska repareras.
     * @return Den nyskapade ordern.
     */
    public RepairOrder createRepairOrder(Customer customer, Bike bike) { // Metod för att skapa order
        // Bild 3, Index 1.1.2: Skapar (instansierar) ett nytt RepairOrder-objekt
        RepairOrder repairOrder = new RepairOrder(customer, bike); 
        
        // Bild 3, Index 1.1.3: Anropar den interna metoden för att spara ordern i listan
        addToList(repairOrder); 
        
        return repairOrder; // Skickar tillbaka den nya ordern till kontrollern
    } // Slut på metoden createRepairOrder

    /**
     * Bild 3, Index 1.1.3: Lägger till en order i den interna listan.
     */
    private void addToList(RepairOrder repairOrder) { // Privat hjälpmetod
        this.repairOrders.add(repairOrder); // Sparar objektet i attributet repairOrders
    } // Slut på metoden addToList

    /**
     * Bild 4, Index 1.1: Hämtar en befintlig order ur registret.
     * @param orderID ID-numret på ordern som söks.
     * @return RepairOrder-objektet om det finns, annars null.
     */
    public RepairOrder getOrder(int orderID) { // Metod för att hämta order
        for (RepairOrder order : repairOrders) { // Går igenom listan med sparade ordrar
            if (order.getOrderId() == orderID) { // Kollar om ID stämmer överens
                return order; // Returnerar den hittade ordern
            } // Slut på if
        } // Slut på for-loopen
        return null; // Returnerar null om order-ID:t inte fanns
    } // Slut på metoden getOrder
} // Slut på klassen RepairOrderRegistry