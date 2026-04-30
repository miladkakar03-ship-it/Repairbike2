package se.kth.iv1350.repairbike.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklass för RepairOrder.
 * Fokuserar på tillståndshantering och logik enligt Task 2 kraven.
 */
public class RepairOrderTest {
    private RepairOrder orderToTest;
    private Customer testCustomer;
    private Bike testBike;

    @BeforeEach
    public void setUp() {
        // Grundläggande setup för att kunna skapa en order
        testBike = new Bike("Yosemite", "Electric S1", "SN12345");
        testCustomer = new Customer("Sven Svensson", "0701112233", "sven@kth.se", testBike);
        orderToTest = new RepairOrder(testCustomer, testBike);
    }

    @AfterEach
    public void tearDown() {
        orderToTest = null;
        testCustomer = null;
        testBike = null;
    }

    /**
     * Testar att orderns status ändras korrekt. 
     * Detta är viktigt för affärsreglerna i steg 17 och 20.[cite: 1]
     */
    @Test
    public void testStateTransition() {
        // Kontrollera startstatus
        assertEquals("Newly Created", orderToTest.getState(), "Initial status stämmer ej.");

        // Testa ändring till 'Ready for approval' (Bild 5)
        orderToTest.setState("Ready for approval");
        assertEquals("Ready for approval", orderToTest.getState(), "Status uppdaterades inte korrekt.");

        // Testa ändring till 'Accepted' (Bild 7)
        orderToTest.setState("Accepted");
        assertEquals("Accepted", orderToTest.getState(), "Status ändrades inte till Accepted.");
    }

    /**
     * Testar att lägga till en problembeskrivning.
     */
    @Test
    public void testAddProblemDescription() {
        String description = "Motorn hackar vid belastning.";
        orderToTest.setProblemDescription(description);
        
        // Verifierar att metoden kan köras. 
        // Notera: För att verifiera värdet med assertEquals krävs en getter för problemDescription.
    }

    /**
     * Testar att lägga till ett reparationsmoment (Bild 6).
     * Detta testar att metoden addRepairTask fungerar utan att kasta undantag.
     */
    @Test
    public void testAddRepairTask() {
        try {
            orderToTest.addRepairTask("Batteriservice", 450.0);
            // Metoden anropas framgångsrikt.
        } catch (Exception e) {
            fail("Kunde inte lägga till RepairTask: " + e.getMessage());
        }
    }
}