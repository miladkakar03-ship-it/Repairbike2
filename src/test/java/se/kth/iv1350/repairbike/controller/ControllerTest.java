package se.kth.iv1350.repairbike.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.repairbike.integration.CustomerRegistry;
import se.kth.iv1350.repairbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairbike.model.CustomerDTO;
import se.kth.iv1350.repairbike.model.RepairOrderDTO;

/**
 * Testklass som verifierar att systemets controller hanterar kommunikation
 * mellan lagren och utför systemoperationer korrekt.
 */
public class ControllerTest {
    private Controller instance;

    /**
     * Sätter upp en ren testmiljö med nya register och en ny controller
     * inför varje enskilt testfall.
     */
    @BeforeEach
    public void setUp() {
        CustomerRegistry custReg = new CustomerRegistry();
        RepairOrderRegistry repReg = new RepairOrderRegistry();
        instance = new Controller(custReg, repReg);
    }

    /**
     * Verifierar att findCustomer returnerar ett korrekt CustomerDTO-objekt
     * när ett existerande telefonnummer skickas in.
     */
    @Test
    public void testFindCustomer() {
        String phoneNumber = "0701112233"; 
        CustomerDTO result = instance.findCustomer(phoneNumber);
        assertNotNull(result, "Kunden borde hittas i registret.");
    }

    /**
     * Testar att en ny reparationsorder kan startas och att en giltig 
     * RepairOrderDTO returneras till vyn.
     */
    @Test
    public void testStartNewRepair() {
        CustomerDTO customer = instance.findCustomer("0701112233");
        RepairOrderDTO result = instance.startNewRepair(customer);
        assertNotNull(result, "En RepairOrderDTO borde ha skapats.");
    }

    /**
     * Kontrollerar att en diagnostisk rapport kan läggas till på en aktiv order
     * och att den uppdaterade ordern returneras.
     */
    @Test
    public void testAddDiagnosticReport() {
        CustomerDTO customer = instance.findCustomer("0701112233");
        RepairOrderDTO newOrder = instance.startNewRepair(customer); 
        
        instance.findRepairOrder(newOrder.getOrderId());
        
        RepairOrderDTO result = instance.addDiagnosticReport("Test-diagnos");
        assertNotNull(result, "Metoden borde returnera den uppdaterade ordern.");
    }

    /**
     * Verifierar att bekräftelse av en order ändrar dess status till "Accepted"
     * enligt systemets affärsregler.
     */
    @Test
    public void testConfirmRepairOrder() {
        CustomerDTO customer = instance.findCustomer("0701112233");
        RepairOrderDTO newOrder = instance.startNewRepair(customer);
        instance.findRepairOrder(newOrder.getOrderId());
        
        RepairOrderDTO confirmed = instance.confirmRepairOrder();
        assertNotNull(confirmed, "Den bekräftade ordern får inte vara null.");
        assertEquals("Accepted", confirmed.getStatus(), "Statusen borde vara Accepted.");
    }
}