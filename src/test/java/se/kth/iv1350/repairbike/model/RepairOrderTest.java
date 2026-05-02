package se.kth.iv1350.repairbike.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklass för att verifiera logiken i RepairOrder.
 */
public class RepairOrderTest {
    private RepairOrder order;

    @BeforeEach
    public void setUp() {
        // Skapar en testmiljö med en kund och en order inför varje test
        Customer testCustomer = new Customer("Sven", "123", "a@b.com", null);
        order = new RepairOrder(testCustomer, null);
    }

    @Test
    public void testStatusChange() {
        // Kontrollerar att startstatus är korrekt
        assertEquals("Newly Created", order.getState(), "Startstatus var fel.");
        
        // Simulerar godkännande av order och verifierar statusändring
        order.setState("Accepted");
        assertEquals("Accepted", order.getState(), "Status ändrades inte korrekt.");
    }

    @Test
    public void testAddRepairTask() {
        // Verifierar att det går att lägga till arbetsmoment utan fel
        order.addRepairTask("Service", 100.0);
        assertNotNull(order, "Ordern bör fortfarande existera efter tillagt moment.");
        
        // Verifierar att kostnaden summeras (om getTotalCost finns i din RepairOrder)
        assertEquals(100.0, order.getTotalCost(), 0.01, "Kostnaden för momentet registrerades inte korrekt.");
    }
}