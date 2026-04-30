package se.kth.iv1350.repairbike.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.repairbike.integration.CustomerRegistry;
import se.kth.iv1350.repairbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairbike.model.CustomerDTO;
import se.kth.iv1350.repairbike.model.RepairOrderDTO;

public class ControllerTest {
    private Controller instance;

    @BeforeEach
    public void setUp() {
        // Test Initial: Skapar ny miljö inför varje test
        CustomerRegistry custReg = new CustomerRegistry();
        RepairOrderRegistry repReg = new RepairOrderRegistry();
        instance = new Controller(custReg, repReg);
    }

    @Test
    public void testFindCustomer() {
        String phoneNumber = "0701112233"; 
        CustomerDTO result = instance.findCustomer(phoneNumber);
        assertNotNull(result, "Kunden borde hittas i registret.");
    }

    @Test
    public void testStartNewRepair() {
        CustomerDTO customer = instance.findCustomer("0701112233");
        RepairOrderDTO result = instance.startNewRepair(customer);
        assertNotNull(result, "En RepairOrderDTO borde ha skapats.");
    }

    @Test
    public void testAddDiagnosticReport() {
        // 1. Skapa ordern
        CustomerDTO customer = instance.findCustomer("0701112233");
        RepairOrderDTO newOrder = instance.startNewRepair(customer); 
        
        // 2. Gör ordern aktiv i controllern med RÄTT metodnamn: getOrderId()
        instance.findRepairOrder(newOrder.getOrderId());
        
        // 3. Lägg till rapporten
        RepairOrderDTO result = instance.addDiagnosticReport("Test-diagnos");
        assertNotNull(result, "Metoden borde returnera den uppdaterade ordern.");
    }

    @Test
    public void testConfirmRepairOrder() {
        // 1. Förberedelse
        CustomerDTO customer = instance.findCustomer("0701112233");
        RepairOrderDTO newOrder = instance.startNewRepair(customer);
        instance.findRepairOrder(newOrder.getOrderId());
        
        // 2. Bekräfta
        RepairOrderDTO confirmed = instance.confirmRepairOrder();
        assertNotNull(confirmed, "Den bekräftade ordern får inte vara null.");
        assertEquals("Accepted", confirmed.getStatus(), "Statusen borde vara Accepted.");
    }
}